
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.*;

import static java.lang.reflect.Modifier.isFinal;
import static java.lang.reflect.Modifier.isStatic;

    public class MegaSena03 {

        private static final Set<Class<?>> INTEGER_TYPES = new HashSet<>();

        static {
            INTEGER_TYPES.add(Integer.class);	INTEGER_TYPES.add(int.class);
            INTEGER_TYPES.add(Long.class);		INTEGER_TYPES.add(long.class);
            INTEGER_TYPES.add(Short.class);		INTEGER_TYPES.add(short.class);
            INTEGER_TYPES.add(Byte.class);		INTEGER_TYPES.add(byte.class);
            INTEGER_TYPES.add(BigInteger.class);
        }

        public static int countIntegerConstants(Class<?> clazz) {
            if (!isClasseComConst(clazz)) {
                return -1;
            }

            List<Field> fields = getFieldsFromClass(clazz);

            int count = 0;
            for (Field field : fields) {
                if (isIntConst(field)) {
                    System.out.println("Int Constant:" + field);
                    count++;
                }
            }
            return count;
        }

        public static boolean isClasseComConst(Class<?> clazz) {
            return clazz != null && !clazz.isEnum()
                    && !Modifier.isAbstract(clazz.getModifiers());
        }

        public static List<Field> getFieldsFromClass(Class<?> clazz) {
            List<Field> fields = new ArrayList<>();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null && !superClass.equals(Object.class)) {
                fields.addAll(getFieldsFromClass(superClass));
            }
            return fields;

        }

        public static boolean isIntConst(Field field) {
            return INTEGER_TYPES.contains(field.getType())
                    && isStatic(field.getModifiers())
                    && isFinal(field.getModifiers());
        }
    }


