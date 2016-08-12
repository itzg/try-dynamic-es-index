package me.itzg;

import me.itzg.services.ProfilesService;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.data.elasticsearch.properties.path.data=target/es-data"}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DemoApplicationTests {

    @Autowired
    private ProfilesService profilesService;

    @Autowired
    private Client client;

    @Test
	@WithUserDetails
	public void testAuthenticatedRequest() throws Exception {

        profilesService.storeUser("me");
        client.admin().indices().prepareFlush().setWaitIfOngoing(true).get();

        final SearchHit searchHit = client.prepareSearch()
                .get().getHits().getAt(0);
        final String indexOfResult = searchHit.getIndex();
        assertEquals("app_sw", indexOfResult);
        assertEquals("me", searchHit.getSource().get("name"));
    }

}
