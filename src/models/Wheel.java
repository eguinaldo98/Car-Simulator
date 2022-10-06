package models;

public class Wheel {
	private int aro;
	private int calibration;
	private double aderencia;
	
	public Wheel(int aro, int calibration, double d){
		this.aro = aro;
		this.calibration = calibration;
		this.aderencia = d;
	}

	public int getCalibration() {
		return calibration;
	}

	public void setCalibration(int calibration) {
		this.calibration = calibration;
	}

	public double getAderencia() {
		return aderencia;
	}

	public void setAderencia(int aderencia) {
		this.aderencia = aderencia;
	}

	public int getAro() {
		return aro;
	}
	
}
