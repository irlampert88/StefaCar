package com.stefanini.stefacar.controller.warehouse;

public enum TypeOfPayment {
	A_VISTA("AVI", "dinheiro") {
		@Override
		public double calculateFinalValue(Double price) {
			return (price * 0.9);
		}
	},
	CREDITO("CRE", "cartão de crédito 3x") {
		@Override
		public double calculateFinalValue(Double price) {
			return (price);
		}
	},
	DEBITO("DEB", "cartão de débito") {
		@Override
		public double calculateFinalValue(Double price) {
			return (price * 0.9);
		}
	},
	BOLETO24("B24", "boleto 24X") {
		@Override
		public double calculateFinalValue(Double price) {
			return calculateWhenParcels(price, 24);
		}
	},
	BOLETO36("B36", "boleto 36X") {
		@Override
		public double calculateFinalValue(Double price) {
			return calculateWhenParcels(price, 36);
		}
	},
	BOLETO48("B48", "boleto 48X") {
		@Override
		public double calculateFinalValue(Double price) {
			return calculateWhenParcels(price, 48);
		}
	};
	
	private String id;
	private String label;
	
	private TypeOfPayment(String id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getLabel(){
		return this.label;
	}

	private static double calculateWhenParcels(double originalPrice, int quantityOfParcels) {
		double valorTotal=0;
		double parcela = originalPrice/quantityOfParcels;
		for (int i = 0; i < (quantityOfParcels-1); i++) {
			valorTotal += parcela * 1.3;
		}
		return valorTotal;
	}
	
	public abstract double calculateFinalValue(Double price); 
	
}
