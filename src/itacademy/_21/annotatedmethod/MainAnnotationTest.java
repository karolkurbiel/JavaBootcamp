package itacademy._21.annotatedmethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainAnnotationTest {
    private static final Phone myUberPhone;
    private static List<String> nameList;

    static {
        initNamesList();
        myUberPhone = Phone.getInstance();
        myUberPhone.switchPowerButton();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<? extends Phone> phone = myUberPhone.getClass();
        Method[] methods = phone.getDeclaredMethods();
        Method add = Phone.class.getDeclaredMethod("addNewContact", String.class, String.class);
        Method call = Phone.class.getDeclaredMethod("callNumberFromContactList", String.class);
        Method callInternal = Phone.class.getDeclaredMethod("callNumber", String.class);
        Execute annotation;

        for(Method method : methods) {
            if(method.isAnnotationPresent(Execute.class)) {
                System.out.println("Method: " + method.getName());
                annotation = method.getAnnotation(Execute.class);

                for(int i = 0; i < annotation.times(); i++) {
                    if(method.equals(add)) {
                        String number = "45365467" + String.format("%02d", i);
                        try {
                            add.invoke(myUberPhone,nameList.get(i),number);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                    if(method.equals(callInternal)) {
                        try {
                            call.invoke(myUberPhone,nameList.get(i));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if(method.equals(add)) {
                    System.out.println(myUberPhone.getContactList());
                }
            }
        }
    }

    private static void initNamesList() {
        nameList = new ArrayList<>();
        nameList.add("Hubert");
        nameList.add("Annamarie");
        nameList.add("Maricruz");
        nameList.add("Lorine");
        nameList.add("Ronnie");
        nameList.add("Britta");
        nameList.add("Wynell");
        nameList.add("Valery");
        nameList.add("Tiffiny");
        nameList.add("Criselda");
        nameList.add("Lamar");
        nameList.add("Kelvin");
        nameList.add("Luise");
        nameList.add("Delicia");
        nameList.add("Magdalene");
        nameList.add("Domingo");
        nameList.add("Brigitte");
        nameList.add("Shawanna");
        nameList.add("Neda");
        nameList.add("Dionna");
        nameList.add("Johnette");
        nameList.add("Raymonde");
        nameList.add("Wyatt");
        nameList.add("Hermelinda");
        nameList.add("Marni");
        nameList.add("Julius");
        nameList.add("Celestina");
        nameList.add("Cira");
        nameList.add("Frances");
        nameList.add("Dolly");
        nameList.add("Fidela");
        nameList.add("Angele");
        nameList.add("Polly");
        nameList.add("Calista");
        nameList.add("Harriet");
        nameList.add("Nicol");
        nameList.add("Nannette");
        nameList.add("Sharan");
        nameList.add("Merlin");
        nameList.add("Alesia");
        nameList.add("Grisel");
        nameList.add("Analisa");
        nameList.add("Christoper");
        nameList.add("Tony");
        nameList.add("Mariann");
        nameList.add("Joan");
        nameList.add("Serina");
        nameList.add("Francoise");
        nameList.add("Beata");
        nameList.add("Clair");
    }
}
