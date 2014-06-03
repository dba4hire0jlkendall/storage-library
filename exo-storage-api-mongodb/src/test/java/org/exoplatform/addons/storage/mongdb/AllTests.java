package org.exoplatform.addons.storage.mongdb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = {
        UserTestCase.class,
        SpaceTestCase.class,
        TeamTestCase.class,
        ChatTestCase.class,
        NotificationTestCase.class
})


public class AllTests {
}
