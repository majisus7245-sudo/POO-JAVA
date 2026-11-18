//Nombre: Manuel de Jesus Inzunza Lara
//No. Control: 23170195
//Materia: Programacion orientada a objetos
//Unidad: 2
//Proyecto: Examen
//Fecha: 08 de marzo del 2024
//Maestro Dr. Clemente Garcia Gerardo
package ClasesYObjetos.examen.primer_parcial;

import Unidad0_Diagnostico.tareas.metodos_de_cadena.Rutinas;

class Empleado {
    private String nombre;
    private int id;
    private int accesosRestantes;

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        accesosRestantes = Rutinas.nextInt(1000, 1500);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccesosRestantes() {
		return accesosRestantes;
	}

	public void setAccesosRestantes(int accesosRestantes) {
		this.accesosRestantes = accesosRestantes;
	}
    

}

class Torniquete {
    private Empleado[] empleados;
    private int[] idEmpleado;
    private int[] AccEmpleados;
    private int totalEmpleados;
    private int totalJefes;

    public Torniquete(int totalEmpleados, String[] jefes) {
        this.totalEmpleados = totalEmpleados;
        this.totalJefes = jefes.length;

        empleados = new Empleado[totalEmpleados]; // CON ESTE ARREGLO ES SUFICIENTE PARA LA SOLUCIÓN DEL PROBLEMA
        idEmpleado = new int[totalEmpleados];
        AccEmpleados = new int[totalEmpleados];


    }

	public Empleado[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}

	public int[] getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int[] idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int[] getAccEmpleados() {
		return AccEmpleados;
	}

	public void setAccEmpleados(int[] accEmpleados) {
		AccEmpleados = accEmpleados;
	}

	public int getTotalEmpleados() {
		return totalEmpleados;
	}

	public void setTotalEmpleados(int totalEmpleados) {
		this.totalEmpleados = totalEmpleados;
	}

	public int getTotalJefes() {
		return totalJefes;
	}

	public void setTotalJefes(int totalJefes) {
		this.totalJefes = totalJefes;
	}
    

}


