package wang.ismy.bloga.service;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.bloga.dao.TagDao;
import wang.ismy.bloga.entity.Tag;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public List<Tag> getTags(){
        return tagDao.getTags();
    }
}