package pl.llasso.service;

import org.springframework.stereotype.Service;
import pl.llasso.Controller.PublisherDao;
import pl.llasso.entity.Publisher;

import javax.transaction.Transactional;

@Service
@Transactional
public class PublisherService {
    PublisherDao publisherDao;

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    public void create(Publisher publisher){
        publisherDao.create(publisher);
    }
    public Publisher readById(Long id){
       return publisherDao.readById(id);
    }
    public void update(Publisher publisher){
        publisherDao.update(publisher);
    }
    public void deleteById(Long id){
        publisherDao.deleteById(id);
    }
}
