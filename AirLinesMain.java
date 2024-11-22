package br.com.smartweb.airlines;

public class AirLinesMain {

	public static void main(String[] args) {
		System.out.println("======================== SMARTWEB AIRLINES ========================");
		var servicoDeReserva = new ServicoDeReserva();
        var servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
        Voo_old voo = new Voo_old("G31333", "UDI", "GRU");

        servicoDeReserva.adicionar(new Reserva("28A888", voo, "Juca Ferreira do Nascimento"));
        servicoDeReserva.adicionar(new Reserva("28B111", voo, "Mari Lins da Fonseca"));
        servicoDeReserva.adicionar(new Reserva("74F877", voo, "Sebastião Coelho Beltrão"));

        try {
        	
        	
	            servicoDeBagagem.contratar("28AXXX", 2);  
	        } catch (ReservaNaoEncontradaException e) {
	            System.err.println("Erro: " + e.getMessage());  
	        }
        
        
        try {
            	servicoDeBagagem.contratar("28A888", 2);  
        } catch (IllegalArgumentException e) {
            	System.err.println("Erro de argumento: " + e.getMessage());  
        }

        servicoDeReserva.getReservas().forEach(System.out::println);
        
        System.err.println("=====================================================================");

	}

}
