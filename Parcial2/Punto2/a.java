package Punto2;

public class a {
	

	    private final static char SEXO_POR_DEFECTO = 'H';
	    private final static int PESO_BAJO = -1;
	    private final static int PESO_IDEAL = 0;
	    private final static int SOBREPESO = 1;
	    private final static int EDAD_MINIMA = 18;
	    private final static String LETRAS_DNI = "eeertytrd";
	    
	    private String nombre;
	    private int edad;
	    private String DNI;
	    private char sexo;
	    private double peso;
	    private double altura;

	    public Persona() {
	        this("", 0, SEXO_POR_DEFECTO, 0, 0);
	    }

	    public Persona(String nombre, int edad, char sexo) {
	        this(nombre, edad, sexo, 0, 0);
	    }

	    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.sexo = sexo;
	        this.peso = peso;
	        this.altura = altura;
	        generarDNI();
	    }

	    private void generarDNI() {
	        int numDNI = (int) (Math.random() * 100000000);
	        int letraDNI = numDNI % 23;
	        this.DNI = String.valueOf(numDNI) + LETRAS_DNI.charAt(letraDNI);
	    }

	    private boolean esMayorDeEdad() {
	        return edad >= EDAD_MINIMA;
	    }

	    private int calcularIMC() {
	        double imc = peso / Math.pow(altura, 2);
	        if (imc < 20) {
	            return PESO_BAJO;
	        } else if (imc >= 20 && imc <= 25) {
	            return PESO_IDEAL;
	        } else {
	            return SOBREPESO;
	        }
	    }

	    private boolean comprobarSexo(char sexo) {
	        return sexo == 'H' || sexo == 'M';
	    }

	    @Override
	    public String toString() {
	        String estadoPeso;
	        int valorIMC = calcularIMC();
	        switch (valorIMC) {
	            case PESO_BAJO:
	                estadoPeso = "Está por debajo de su peso ideal";
	                break;
	            case PESO_IDEAL:
	                estadoPeso = "Está en su peso ideal";
	                break;
	            default:
	                estadoPeso = "Tiene sobrepeso";
	                break;
	        }
	        String mayorEdad = esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad";
	        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo + "\nPeso: " + peso
	                + "\nAltura: " + altura + "\n" + estadoPeso + "\n" + mayorEdad;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public void setSexo(char sexo) {
	        this.sexo = sexo;
	    }

	    public void setPeso(double peso) {
	        this.peso = peso;
	    }

	    public void setAltura(double altura) {
	        this.altura = altura;
	    }
	}

}
