package wang.ismy.bloga.constant;

public enum ArticleEnum {

    PAGE_NUMBER_OUT_BOUND("页数下标炸了"),

    ARTICLE_NOT_EXIST("文章不存在"),

    ARTICLE_TAG_NOT_NULL("文章标签不能为空"),

    FILE_NOT_EXIST("没有此归档结果"),

    FILE_NOT_NULL("归档条件不能为空"),

    SEARCH_NOT_NULL("搜索条件不能为空"),

    ARTICLE_NOT_NULL("文章为空"),

    ARTICLE_ID_NOT_NULL("文章ID不能为空");

    private String msg;
    ArticleEnum(String msg) {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
