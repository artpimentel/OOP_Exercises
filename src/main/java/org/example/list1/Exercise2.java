package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
}

public class Exercise2 implements Executable {
    public static double distCalculator(Point3D p1, Point3D p2) {
        double dx, dy, dz, distQuadrada, dist;

        dx = p2.getX() - p1.getX();
        dy = p2.getY() - p1.getY();
        dz = p2.getZ() - p1.getZ();

        distQuadrada = Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2);

        dist = Math.sqrt(distQuadrada);

        return dist;
    }

    @Override
    public void run() {
        System.out.println("Executando o Exercise1...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        double ax,ay,az,bx,by,bz;

        System.out.println("Onde esta o ponto a?");
        System.out.print("Coordenada x: ");
        ax = teclado.nextInt();
        System.out.print("Coordenada y: ");
        ay = teclado.nextInt();
        System.out.print("Coordenada z: ");
        az = teclado.nextInt();

        Point3D aPoint = new Point3D(ax, ay, az);

        System.out.println("Onde esta o ponto b?");
        System.out.print("Coordenada x: ");
        bx = teclado.nextInt();
        System.out.print("Coordenada y: ");
        by = teclado.nextInt();
        System.out.print("Coordenada z: ");
        bz = teclado.nextInt();

        Point3D bPoint = new Point3D(bx, by, bz);

        double d = distCalculator(aPoint, bPoint);

        System.out.println("O Ponto A, que está em: " + aPoint.getX() + ", " + aPoint.getY() + ", " + aPoint.getZ());
        System.out.println("E o Ponto B, que está em: " + bPoint.getX() + ", " + bPoint.getY() + ", " + bPoint.getZ());
        System.out.println("Estão a " + d + "unidades de distância.");
    }
}
