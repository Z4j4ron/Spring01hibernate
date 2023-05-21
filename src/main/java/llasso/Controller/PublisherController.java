package pl.llasso.Controller;

import org.springframework.web.bind.annotation.*;
import pl.llasso.service.PublisherService;
import pl.llasso.entity.Publisher;

@RestController
public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    @RequestMapping("/publisher/{id}")
    @ResponseBody
    public Publisher findById(@PathVariable long id) {
        return publisherService.readById(id);
    }

    @PostMapping(path = "/publisher")
    void save(@RequestParam String name) {

        final Publisher publisher = new Publisher();

        publisher.setName(name);
        publisherService.create(publisher);

    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherService.readById(id);
        publisher.setName(name);
        publisherService.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        publisherService.deleteById(id);
        return "deleted";
    }

}
