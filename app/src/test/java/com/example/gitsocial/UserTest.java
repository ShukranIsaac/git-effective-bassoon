package com.example.gitsocial;

import com.example.gitsocial.domain.Owner;
import com.example.gitsocial.domain.Plan;
import com.example.gitsocial.domain.Repo;
import com.example.gitsocial.domain.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserTest {
    @Test
    public void should_create_user_object() {
        Plan plan = Plan.builder().build();
        User user = User.builder().plan(plan).avatar_url("https://").build();

        assertNotEquals(user, User.builder().build());
        assertNotEquals(plan, Plan.builder().build());
        assertEquals(user.plan().collaborators(), User.builder().plan(plan).build()
                .plan().collaborators());

        assertEquals(user.avatar_url(), "https://");
    }

    @Test
    public void should_create_repo_object() {
        Repo repo = Repo.builder().build();
        assertNotEquals(repo, Repo.builder().build());
        assertEquals(repo.owner(), Repo.builder().build().owner());
    }

    @Test
    public void should_create_owner_object() {
        Owner owner = Owner.builder().build();
        assertNotEquals(owner, Owner.builder().build());
    }
}