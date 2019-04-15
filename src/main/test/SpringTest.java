package fi.vamk.tka.reactspring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import fi.vamk.tka.reactspring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackageClasses = GroupRepository.class)
public class SpringTest{
    @Autowired
    private GroupRepository repository;
    @Test
    public void addingGroupTest(){
        //luodaan tyhjä group olio
        Group mygroup = new Group();
        //laitetaan sille nimeksi jotain
        item.setName("Vaasa JUG");
        // tallennetaan se kantaan
        repository.save(mygroup);
        // katsotaan löytyykö kannasta tuo tallennettu
        // laitetaan se uuteen olioon
        Group found = repository.findByName(mygroup.getName());
        // then
        // sitten verrataan onko kannasta haettu sama kuin sinne laitettu
      assertEquals(found.getName(), mygroup.getName());
		//remove the data from persistant database
		repository.delete(found);
        
    }
    @Test
    public void helloYouTest(){
        System.out.println("Onko kesä koittanut");
    }
    
    @Test
    public void springTest(){
       System.out.println("Is it already spring?");
    }
}