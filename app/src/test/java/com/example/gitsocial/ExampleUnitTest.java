package com.example.gitsocial;

import com.example.gitsocial.entities.Computer;
import com.example.gitsocial.entities.Plan;
import com.example.gitsocial.entities.Repo;
import com.example.gitsocial.entities.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void user_object_created() {
        Plan plan = Plan.builder().build();
        User user = User.builder().plan(plan).build();

        assertEquals(user.plan().collaborators(),
                User.builder().plan(plan).build().plan().collaborators());
    }

    @Test
    public void repo_object_created() {
        Repo repo = Repo.builder().build();
        assertEquals(repo.owner(), Repo.builder().build().owner());
    }

    @Test
    public void should_pass_test() {
        Computer computer = Computer.builder()
                .deleted(true)
                .model("RTX")
                .manufacturer("INTEL")
                .build();

        assertNotEquals(computer.deleted(), false);
    }
}