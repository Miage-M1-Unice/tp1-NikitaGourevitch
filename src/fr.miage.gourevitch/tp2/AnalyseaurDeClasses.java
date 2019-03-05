package fr.miage.gourevitch.tp2;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnalyseaurDeClasses {

    Class classToAnnalyse;

    public AnalyseaurDeClasses(Object o) {
        this.classToAnnalyse = o.getClass();
        this.classAcssessibility();
        this.className();
        this.eritageList();
        this.atributList();
        this.constructorlist();
        this.methodsList();
        System.out.print("\n }");

    }

    static public void main(String[] args) {
        AnalyseaurDeClasses analyseurDeClasse = new AnalyseaurDeClasses(new Point());
    }

    public void classAcssessibility() {
        System.out.print(Modifier.toString(this.classToAnnalyse.getModifiers()) + " ");
    }

    public void className() {
        System.out.print(this.classToAnnalyse.getName());
    }

    public void eritageList() {
        if (this.classToAnnalyse.getSuperclass() != null) {
            System.out.print(" extends " + classToAnnalyse.getSuperclass().getName());
        }

        System.out.print(" implements ");
        if (this.classToAnnalyse.getInterfaces() != null) {
            for (Class clas : this.classToAnnalyse.getInterfaces()) {
                System.out.print(clas.getName());
            }
        }
        System.out.print(" { \n");
    }

    public void atributList() {
        System.out.println("\n // Champs ");
        for (Field field : this.classToAnnalyse.getDeclaredFields()) {
            System.out.println("\t" + field);
        }
    }

    public void methodsList (){
        System.out.println("\n // Methods");
        for (Method method : this.classToAnnalyse.getDeclaredMethods()){
            System.out.println("\t" + method);
        }
    }

    public void constructorlist() {
        System.out.println("\n // Constructeurs  ");
        for (Constructor constructor : this.classToAnnalyse.getConstructors()) {
            System.out.println("\t" + constructor);
        }
    }


}
