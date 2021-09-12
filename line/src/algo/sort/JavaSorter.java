package algo.sort;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JavaSorter {
    // 对于基本类型数据，不需要稳定
    // 对于小数据量（小于47）的话使用插入排序
    // 对于小数据量（大于47而小于286）的话使用快速排序
    // 对于大数据量的话使用迭代实现的归并排序，因为递归会导致栈溢出

    // 对于引用类型数据，需稳定
    // 小规模数据的话选择插入排序
    // 大规模数据的话选择归并排序
    // (老版本使用的是递归实现的归并，而新版本使用的是迭代实现的归并)
    public static void main(String[] args) {
        int[] data = new int[]{34, 33, 12, 78, 21, 1, 98, 100};
        Arrays.sort(data); // 通用的排序
        System.out.println(Arrays.toString(data));

        Person p1 = new Person("douma", 40);
        Person p2 = new Person("laotang", 30);
        Person p3 = new Person("douma1", 32);
        Person p4 = new Person("laotang2", 33);
        Person[] people = new Person[]{p1, p2, p3, p4};

        System.out.println(p1.compareTo(p2)); // 10
        System.out.println(p2.compareTo(p1)); // -10

        // Comparator比较器
        PersonComparator pc = new PersonComparator();
        System.out.println(pc.compare(p1,p2)); //10
        System.out.println(pc.compare(p2,p1)); //-10

        Comparator<Person> cp = new Comparator<Person>() { // 匿名内部类
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        System.out.println(cp.compare(p1,p2)); //10
        System.out.println(cp.compare(p2,p1)); //-10

        Comparator<Person> comparator = ((o1, o2) -> o1.getAge() - o2.getAge()); // lambda表达式
        System.out.println(comparator.compare(p1,p2)); //10
        System.out.println(comparator.compare(p2,p1)); //-10

        Arrays.sort(people); // Person类实现了Comparable接口
        System.out.println(Arrays.toString(people));
        Arrays.sort(people, comparator); // Comparator比较器
        System.out.println(Arrays.toString(people));

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list); // Person类实现了Comparable接口
        System.out.println(list);
        // 底层：Arrays.sort
        Collections.sort(list, comparator); // Comparator比较器
        System.out.println(list);
    }
}
