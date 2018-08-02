package wang.ismy.bloga.service.ws;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.config.Config;
import wang.ismy.bloga.constant.UploadEnum;
import wang.ismy.bloga.exception.UploadException;

import javax.persistence.Access;

@Service
public class UploadService {


    private static Config config=new Config();

    private static String endpoint = "oss-cn-qingdao.aliyuncs.com";
    private static String accessKeyId = config.getId(); //阿里OOSid
    private static String accessKeySecret =config.getSecret(); //阿里OOSsecret
    private static String bucketName = "ismy1"; //OOS 桶名
    private static String key = "<downloadKey>";
    private static String uploadFile = "<uploadFile>";

    public String aliyunUpload(String uri){
        key="blog/"+System.currentTimeMillis();
        String back=uri.substring(uri.lastIndexOf("."),uri.length());
        key+=back;
        uploadFile=uri;
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
            // 待上传的本地文件
            uploadFileRequest.setUploadFile(uploadFile);
            // 设置并发下载数，默认1
            uploadFileRequest.setTaskNum(5);
            // 设置分片大小，默认100KB
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // 开启断点续传，默认关闭
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
            System.out.println(multipartUploadResult.getETag());

        } catch (OSSException oe) {

            throw new UploadException(new UploadEnum(oe.getErrorCode()));
        } catch (ClientException ce) {
            throw new UploadException(new UploadEnum(ce.getMessage()));

        } catch (Throwable e) {

            throw new UploadException(new UploadEnum(e.getMessage()));
        } finally {
            ossClient.shutdown();
        }
        return "https://"+bucketName+"."+endpoint+"/"+key;
    }
}
