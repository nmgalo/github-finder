package com.github.repo.presentation.users.list

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.repo.HiltTestActivity
import com.github.repo.R
import com.github.repo.presentation.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SearchUsersFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var stringToBeTyped: String

    private lateinit var navController: NavController
    private lateinit var hiltActivityScenario: ActivityScenario<HiltTestActivity>

    @Before
    fun setUp() {
        hiltRule.inject()
        stringToBeTyped = "nmgalo"

        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        hiltActivityScenario = launchFragmentInHiltContainer<SearchUsersFragment> {
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(requireView(), navController)
        }
    }

    @Test
    fun should_showOneItem_whenEnterMyGithubUsername() = runBlocking {
        onView(withId(R.id.search)).perform(typeText(stringToBeTyped), closeSoftKeyboard())
        delay(1500)
        onView(withId(R.id.usersList)).check(matches(hasChildCount(1)))
        Unit
    }

}
