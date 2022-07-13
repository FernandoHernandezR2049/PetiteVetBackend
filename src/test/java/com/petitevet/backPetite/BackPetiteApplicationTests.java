package com.petitevet.backPetite;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petitevet.backPetite.models.ProductModel;

@SpringBootTest
@AutoConfigureMockMvc
class BackPetiteApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	//@Disabled("Se validará posteriormente")
	public void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/products/14") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Prueba de perrito")));
		// pruebaGET
	}// pruebaDELETE
	
	@Test
	//@Disabled("Se validará posteriormente")
	public void pruebaPOST() throws Exception {
		ProductModel p = new ProductModel();
		p.setName("Prueba");
		p.setDescription("Prueba de perrito panzon");
		p.setImg("perritopanzon.jpg");
		p.setPrecio(41.50);
		p.setSKU("RUUUUUNNNN");
		p.setQuantity("5");
		this.mockMvc.perform(post("/api/products/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(p))
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Prueba de perrito panzon")));
		// pruebaGET
	}// pruebaDELETE
	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString
	
	
	@Test
	public void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/products/3").queryParam("name", "Cama")
				// .header("Authorization", "Bear: xxxxxxxxxxxxxxxxx")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Cama")));
	}// pruebaPUT
	
	@Test
	@Disabled("Se validará posteriormente")
	public void prueba404() throws Exception {
		this.mockMvc.perform(get("/api/products/9"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}// prueba404
	
	
	@Test
	void pruebaGet() throws Exception {
	this.mockMvc.perform(get("/api/products/3") )
	.andDo(print())
	.andExpect(status().isOk())
	.andExpect( content().string(containsString("Cama")));
	// pruebaGET
	}// pruebaGET

}//Class
