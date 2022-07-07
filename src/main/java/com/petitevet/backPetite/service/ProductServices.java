package com.petitevet.backPetite.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.ProductModel;

@Service
public class ProductServices {
	public final ArrayList<ProductModel> lista = new ArrayList<>();
	
	public ProductServices() {
		lista.add(new ProductModel("Cepillo canino","Mango ergonómico. Puntas metálicas. "
				+ "Desenreda y quita pelo muerto. Los colores de la imagen pueden variar.", "1.cepillo_canino.png",79, "123"));
		lista.add(new ProductModel("Plato para alimento","Sus dimensiones de 14 x 18 x 4.5 poseen la capacidad suficiente "
				+ "para alimentar a tu mejor amigo y satisfacer su apetito moderado. "
				+ "Los colores de la imagen pueden variar.", "2.plato_de_comida.jpg",199, "123"));
		lista.add(new ProductModel("Cama","Cama tamaño grande fabricada en tela polar con almohadón que se puede sacar para lavar. "
				+ "Medidas de la cama: 110 cm (largo) x 75 cm (ancho) x 25 cm (altura). "
				+ "Los colores de la imagen pueden variar.", "2.plato_de_comida.jpg",250, "123"));
		lista.add(new ProductModel("Correa","Material de la correa: Acero. "
				+ "Peso máximo soportado: 5 kg. Largo: 1.2m", "4.correa_perro.jpg",59, "123"));

	}//contructor
	
	public ArrayList<ProductModel> getProducts(){
		return lista;
	}
	
	public ProductModel getProduct(Long id) {
		ProductModel tmpProd = null;
		for (ProductModel productModel : lista) {
			if(productModel.getId()==id) {
				tmpProd = productModel;
				break;
			}// if
		}//foreach
		return tmpProd;
	}//getPrducto

	public ProductModel deleteProduct(Long id) {
		ProductModel tmpProd = null;
		for (ProductModel productModel : lista) {
			if(productModel.getId()==id) {
				tmpProd = lista.remove(lista.indexOf(productModel));
				break;
			}// if
		}//foreach
		return tmpProd;
	}// deleteProducto

	public ProductModel addProduct(ProductModel productModel) {
		lista.add(productModel);
		return productModel;
	}//addProducto

	public ProductModel updateProduct(Long id, String name, String description, 
			String Img, Double precio) {
		ProductModel tmpProd = null;
		for (ProductModel producto : lista) {
			if(producto.getId()==id) {
				if(name!=null)producto.setDescription(name);
				if(description!=null)producto.setDescription(description);
				if(Img!=null)producto.setImg(Img);
				if(precio!=null)producto.setPrecio(precio.doubleValue());
				tmpProd = producto;
				break;
			}// if
		}//foreach
		return tmpProd;
	}//updateProducto
}
