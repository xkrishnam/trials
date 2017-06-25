package com.khcl.shopstops;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.khcl.shopstops.services.ShopService;
import org.khcl.shopstops.services.gmap.GmapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopControllerTest {

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private GmapServiceImpl gmpImpl;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(shopService).isNotNull();
        assertThat(gmpImpl).isNotNull();
    }
	
	@Test
	public void testShopFindingMethod(){
		
	}
}
