package com.miempresa.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoTest {
	
	// creamos variable o objeto en este caso es producto
	
	Producto producto;
	
	// creamos una exepcion 
	@BeforeEach
	public void setUp() throws Exception {
		producto = new Producto("Portátil", 500);
	}

	// empezamos con Test 
	@Test
	// display es para anadirle nombre a este Test 
	@DisplayName("Debería crear un producto con nombre y precio válidos")
	// empezamos con los Test
	public void testCrearProductoValido() {
		String nombreEsperado = "Portátil";
		double precioEsperado = 500;
		
		// comparamos un valor esperado con un valor actual
		// queremos que el nombre esperado sea el del codigo
		assertEquals(nombreEsperado, producto.getNombre());
		assertEquals(precioEsperado, producto.getPrecio());
	}
	
	@Test
	@DisplayName("Nos debería lanzar una excepción con un mensaje cuando se intenta crear un producto con un precio negativo")
	public void testCrearProductoInvalidoPrecio() {
		// aqui creamos una exepcion que llama a esa calse y despues creamos un nuevo
		// objeot que es pc
		Exception exception = assertThrows(IllegalArgumentException.class, ()->{new Producto("PC", -3);});
		double precioEsperado = -3.0;
		String mensajeEsperado = "El precio no puede ser negativo: "+ precioEsperado;
		assertEquals(mensajeEsperado, exception.getMessage(), "No se corresponde el mensaje");
	}
	
	@Test
	@DisplayName("Prueba de set del nombre del Producto")
	void testModificarNombreProducto() {
		String nameEsperado = "Monitor";
		producto.setNombre("Monitor");
		assertEquals(nameEsperado, producto.getNombre(), "El nombre no se ha modificado correctamente desde el método set");
	}
	
	
	@Test
    @DisplayName("Prueba de set de precio del Producto")
	void testModificarPrecioProducto() {
		double precioEsperado = 150;
		producto.setPrecio(150);
		assertEquals(precioEsperado, producto.getPrecio(), "El precio del producto no se ha modificado correctamente");
	}
	
	@Test
	@DisplayName("Prueba de set precio negativo")
	void testSetPrecioNegativo() {
		Exception exception = assertThrows(IllegalArgumentException.class, ()->producto.setPrecio(-50));
		String mensajeEsperado = "El precio no puede ser negativo: -50.0";
		assertEquals(mensajeEsperado, exception.getMessage());
	}

	@Test
	@DisplayName("Debería manejar correctamente los valores de los extremos")
	void pruebaExtremoTest() {
		producto.setPrecio(Double.MAX_VALUE);
		assertEquals(Double.MAX_VALUE, producto.getPrecio());
		
		
	}
	
	
}
