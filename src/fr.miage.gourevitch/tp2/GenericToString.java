package fr.miage.gourevitch.tp2;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;


public class GenericToString {
    public String toString(Object obj, int deep) throws IllegalAccessException {

        /*if(obj == null){
            return "object null";
        }*/
        if (deep == 0) {
            return obj.getClass().getName() + "@" + System.identityHashCode(obj);
        }
        StringBuilder genericString = new StringBuilder();
        genericString.append(obj.getClass().getName()).append(" [ ");
        for (Field attrib : obj.getClass().getDeclaredFields()) {
            attrib.setAccessible(true);
            Object objAttrs = attrib.get(obj);
            genericString.append(attrib.getName()).append(" = ");

            if (!attrib.getType().isPrimitive()) {
                if (attrib.getType().isArray()) {
                    genericString.append("{ ");
                    for (int i = 0; i < Array.getLength(objAttrs); i++) {
                        genericString.append(Array.get(objAttrs, i).toString()).append(", ");
                    }
                    genericString.append(" };");
                    continue;
                } else return toString(objAttrs, deep - 1);
            }
            genericString.append(objAttrs.toString());
            genericString.append("; ");
        }
        Class aClasss = obj.getClass().getSuperclass();
        while (aClasss != null) {
            for (Field attrib : aClasss.getFields()) {
                attrib.setAccessible(true);
                genericString.append(attrib.getName()).append(" = ");
                Object objField = attrib.get(obj);
                if (!attrib.getType().isPrimitive()) {
                    if (attrib.getType().isArray()) {
                        genericString.append("{ ");
                        for (int i = 0; i < Array.getLength(objField); i++) {
                            genericString.append(Array.get(objField, i).toString()).append(" ,");
                        }
                        genericString.append(" }; ");
                        continue;
                    } else return toString(objField, deep);
                }
                genericString.append(objField.toString());
                genericString.append("; ");
            }
            aClasss = aClasss.getSuperclass();
        }
        return toString(null, deep --);
    }

    static public void main(String[] args) {
        try {
            System.out.println(new GenericToString().toString(new Point(12, 24),1));
            Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20, 30, 40}, 3);
            pol.getBounds();
            System.out.println(new GenericToString().toString(pol, 3));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}


