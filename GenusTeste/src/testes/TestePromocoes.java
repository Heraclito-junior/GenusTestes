package testes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.VendaModificada;
import genus.Funcoes;
import genus.Tipos.Funcionario;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

public class TestePromocoes {
	
	@Mock
	private ArrayList<Produto> mockArrayList;
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	@Mock
	private VendaModificada novaVenda;
	
	List<Produto> listaDeProdutos;
	List<Desconto>listaDeDescontos;
	
	private static boolean setUpIsDone = false;

	@Test
	public void testPromocoesUmProduto() {
		//MockitoAnnotations.initMocks(this);
		setUp();
		
		
		FuncionalidadesNovas test=new FuncionalidadesNovas();
		
		
		
		
		
		when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
		when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
		
		
		
		Produto produtoParaVerificar = novasFuncionalidades.retornarProdutoPorID(1);
		
		when(novasFuncionalidades.calcularDescontoProduto(produtoParaVerificar, listaDeDescontos)).thenReturn(new Produto(1,"tomate",91,0.4,1));
		
		produtoParaVerificar=novasFuncionalidades.calcularDescontoProduto(produtoParaVerificar, listaDeDescontos);
				
		novaVenda=new VendaModificada();
		
		
		
		when(novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda)).thenReturn(new VendaModificada(1,1,1,1,0.4));
		
		novaVenda=novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda);
		
		
		assertEquals(0.4, novaVenda.getValorTotal(), 0.001);		
		
		
	}
	
/**	
	@Test
	public void testPromocoesVariosProduto() {
		
		//MockitoAnnotations.initMocks(this);
		
		
		FuncionalidadesNovas test=new FuncionalidadesNovas();
		
		List<Produto> listaDeProdutos=new ArrayList<Produto>();
		List<Desconto> listaDeDescontos=new ArrayList<Desconto>();
		
		
		
		when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
		when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
		
		
		
		Produto produtoParaVerificar = novasFuncionalidades.retornarProdutoPorID(1);
		
		when(novasFuncionalidades.calcularDescontoProduto(produtoParaVerificar, listaDeDescontos)).thenReturn(new Produto(1,"tomate",91,0.4,1));
		
		produtoParaVerificar=novasFuncionalidades.calcularDescontoProduto(produtoParaVerificar, listaDeDescontos);
				
		novaVenda=new VendaModificada();
		
		
		
		when(novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda)).thenReturn(new VendaModificada(1,1,1,1,0.4));
		
		novaVenda=novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda);
		
		
		assertEquals(0.4, novaVenda.getValorTotal(), 0.001);		
		
		
	}
	
	*/
	
	
	public void setUp() {
	    if (setUpIsDone) {
	        return;
	    }
	  MockitoAnnotations.initMocks(this);
	  
	  Produto auxiliarParaAlocacaoProdutos;
	  Desconto auxiliarParaAlocacaoDesconto;
	    
	  List<Produto> listaDeProdutos=new ArrayList<Produto>();
	  List<Desconto> listaDeDescontos=new ArrayList<Desconto>();
	  
	  
	  when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
	  when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
	  
	  auxiliarParaAlocacaoProdutos=novasFuncionalidades.retornarProdutoPorID(0);
	  listaDeProdutos.add(auxiliarParaAlocacaoProdutos);
	  
	  auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarDescontoPorID(0);
	  
	  listaDeDescontos.add(auxiliarParaAlocacaoDesconto);
	  
	  
	  
	    setUpIsDone = true;
	}
	
	
	
	

}
