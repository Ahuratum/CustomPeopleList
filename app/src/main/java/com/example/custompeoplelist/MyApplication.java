package com.example.custompeoplelist;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Human> humanList = new ArrayList<Human>();
    private static int nextId = 5;

    public MyApplication() {
        fillHumanList();
    }

    private void fillHumanList() {
        Human human0 = new Human(0, "Nicolas Hagen",
                29, "4127584385",
                "nicolasghagen@gmail.com",
                "https://media-exp1.licdn.com/dms/image/C4E03AQEzeTK3T9ayUQ/profile-displayphoto-shrink_200_200/0?e=1609977600&v=beta&t=vYXMFyfuFd1HHoRVBu_mmphPSqAK4d16THwx0RMSxIg");
        Human human1 = new Human(1, "Jenica Stokes",
                22, "412",
                "Jenica@gmail",
                "url");
        Human human2 = new Human(2, "Jessica Stokes",
                19, "412",
                "Jessica@gmail",
                "https://media-exp1.licdn.com/dms/image/C4D03AQEZuMJ8KdobPA/profile-displayphoto-shrink_200_200/0?e=1609977600&v=beta&t=7WLzH0-LlIGmNpVESq5x7IgEWpLUDKgG0P-HT4CSfwI");
        Human human3 = new Human(3, "Matt Norris",
                25, "412",
                "Matt@gmail",
                "https://media-exp1.licdn.com/dms/image/C5103AQGkN95PdFLhRg/profile-displayphoto-shrink_200_200/0?e=1609977600&v=beta&t=RBZ2gI7elfeEmgrsGuJAKR54Gg6OLPFQU4VpjGF7fZ4");
        Human human4 = new Human(4, "Joe Perea",
                28, "412",
                "Joe@gmail",
                "url");

        humanList.addAll(Arrays.asList(new Human[] {human0, human1, human2, human3, human4}));
    }

    public static List<Human> getHumanList() {
        return humanList;
    }

    public static void setHumanList(List<Human> humanArrayList) {
        MyApplication.humanList = humanArrayList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
