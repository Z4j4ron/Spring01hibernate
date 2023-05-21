package pl.llasso.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.llasso.entity.Author;
import pl.llasso.dao.AuthorDao;

public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        authorDao.saveAuthor(author);
        return "Id dodanej książki to:"
                + author.getId();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{name}/{lastName}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String name, @PathVariable String lastName ) {
        Author author = authorDao.findById(id);
        author.setFirstName(name);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }
}
