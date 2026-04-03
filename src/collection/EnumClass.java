package collection;

 enum Enum {
    SUNDAY {
        public void msg() {
            System.out.println("Sunday");
        }
    },
    MONDAY{
        public void msg() {
            System.out.println("Monday");
        }
    },
    TUESDAY{
        public void msg() {
            System.out.println("Tuesday");
        }
    },
    WEDNESDAY{
        public void msg() {
            System.out.println("Wednesday");
        }
    },
    THURSDAY{
        public void msg() {
            System.out.println("Thursday");
        }
    },
    FRIDAY{
        public void msg() {
            System.out.println("Friday");
        }
    },
    SATURDAY{
        public void msg() {
            System.out.println("Saturday");
        }
    };
     void save() {
         System.out.println("Enum class");
     }
      abstract void msg();

 }

public class EnumClass {
    public static void main(String[] args) {
        Enum.FRIDAY.msg();
    }

}


