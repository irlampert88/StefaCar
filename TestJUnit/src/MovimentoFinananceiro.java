import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MovimentoFinananceiro implements Serializable{

	private LocalDate datavencimento;
	private Double valororiginal;
	private Double valorjuros;
	private Double valorpagamento;
	
	
	public void MovFin() {
		// TODO Auto-generated constructor stub
	}
	
	public void geravencimento(LocalDate dataemissao) {
		this.datavencimento = dataemissao;
	
	}
	
	public void calculajuros(Double valororiginal) {
		
	}

	public LocalDate getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(LocalDate datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Double getValororiginal() {
		return valororiginal;
	}

	public void setValororiginal(Double valororiginal) {
		this.valororiginal = valororiginal;
	}

	public Double getValorjuros() {
		return valorjuros;
	}

	public void setValorjuros(Double valorjuros) {
		this.valorjuros = valorjuros;
	}

	public Double getValorpagamento() {
		return valorpagamento;
	}

	public void setValorpagamento(Double valorpagamento) {
		this.valorpagamento = valorpagamento;
	}
	
	
}
