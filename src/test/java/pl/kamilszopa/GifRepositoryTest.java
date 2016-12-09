package pl.kamilszopa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kamilszopa.data.GifRepository;

/**
 * Created by kmlsz on 09.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GifRepositoryTest {

    @Autowired
    private GifRepository gifRepository;

    @Test
    public void getAllGifs()throws Exception{
        Assert.assertEquals(6,gifRepository.getAllGifs().size());
        Assert.assertNotNull(gifRepository.getAllGifs());
    }

}

