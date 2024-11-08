package kotlin.com.jwk.golftracker

class ApplicationTest {
//    companion object {
//        private const val USER_NAME_0 = "Louis"
//        private const val USER_NAME_1 = "Ashlen"
//        private const val USER_NAME_2 = "Heather"
//        private val USER_0 = User(0, USER_NAME_0, 0)
//        private val USER_1 = User(1, USER_NAME_1, 0)
//        private val USER_2 = User(2, USER_NAME_2, 0)
//
//        private val TOP_SCORES_TEST_USER_NAMES = List(50) {
//            "User $it"
//        }
//        private val TOP_SCORES_TEST_USER_SCORES = List(50) {
//            nextInt(0, 50).toLong()
//        }
//        private val TOP_SCORES_TEST_USER_SCORES_SORTED = TOP_SCORES_TEST_USER_SCORES.sortedDescending()
//    }
//
//    private val repo = scoreRepository
//
//    @AfterEach
//    fun cleanup() {
//        runBlocking {
//            repo.clear()
//        }
//    }
//
//    @Test
//    fun getUser_single() = applicationTest {
//        givenUsersAdded()
//        getValidUser(USER_0)
//    }
//
//    @Test
//    fun getUser_multiple() = applicationTest {
//        givenUsersAdded()
//        getValidUser(USER_0)
//        getValidUser(USER_1)
//        getValidUser(USER_2)
//    }
//
//    @Test
//    fun getUser_nonexistent() = applicationTest {
//        givenUsersAdded()
//        checkNoUsers(3)
//        getNonexistentUser(3)
//    }
//
//    @Test
//    fun getUser_invalidId() = applicationTest {
//        givenUsersAdded()
//        getUserInvalidId(USER_NAME_0)
//    }
//
//    @Test
//    fun newUser_single() = applicationTest {
//        checkNoUsers(0)
//        newUser(USER_NAME_0)
//        checkUser(USER_0)
//    }
//
//    @Test
//    fun newUser_multiple() = applicationTest {
//        checkNoUsers(0, 1, 2)
//        newUser(USER_NAME_0)
//        newUser(USER_NAME_1)
//        newUser(USER_NAME_2)
//        checkUsers(USER_0, USER_1, USER_2)
//        checkNoUsers(3)
//    }
//
//    @Test
//    fun newUser_noName() = applicationTest {
//        newUserNoName()
//    }
//
//    @Test
//    fun updateUser_single_nameOnly() = applicationTest {
//        givenUsersAdded()
//        updateValidUser(userId = 0, name = USER_NAME_1)
//        checkUserName(0, USER_NAME_1)
//    }
//
//    @Test
//    fun updateUser_single_scoreOnly() = applicationTest {
//        givenUsersAdded()
//        updateValidUser(userId = 0, score = 5)
//        checkUserScore(0, 5)
//    }
//
//    @Test
//    fun updateUser_since_nameAndScore() = applicationTest {
//        givenUsersAdded()
//        updateValidUser(userId = 0, name = USER_NAME_1, score = 5)
//        checkUser(User(0, USER_NAME_1, 5))
//    }
//
//    @Test
//    fun updateUser_multiple_nameAndScore() = applicationTest {
//        givenUsersAdded()
//        updateValidUser(0, USER_NAME_1, 5)
//        updateValidUser(1, USER_NAME_2, 6)
//        updateValidUser(2, USER_NAME_0, 7)
//        checkUsers(
//            User(0, USER_NAME_1, 5),
//            User(1, USER_NAME_2, 6),
//            User(2, USER_NAME_0, 7)
//        )
//    }
//
//    @Test
//    fun updateUser_nonexistent() = applicationTest {
//        givenUsersAdded()
//        checkNoUsers(3)
//        updateNonExistentUser(3, name = "Any", score = 5)
//    }
//
//    @Test
//    fun updateUser_noParams() = applicationTest {
//        givenUsersAdded()
//        updateUserNoParams(0)
//        checkUser(USER_0)
//    }
//
//    @Test
//    fun updateUser_invalidScoreNoName() = applicationTest {
//        givenUsersAdded()
//        updateUserInvalidScore(0, name=USER_NAME_1, score="Twenty")
//        checkUser(USER_0)
//    }
//
//    @Test
//    fun updateUser_invalidScoreWithName() = applicationTest {
//        givenUsersAdded()
//        updateUserInvalidScore(0, name = USER_NAME_1, score="Twenty")
//        checkUser(USER_0)
//    }
//
//    @Test
//    fun updateUser_invalidId() = applicationTest {
//        givenUsersAdded()
//        updateUserInvalidUserId(userId = USER_NAME_0, name = USER_NAME_1, score = 5)
//        checkUser(USER_0)
//    }
//
//    @Test
//    fun newScore_single_higherScore() = applicationTest {
//        givenUsersAdded()
//        newScoreValidUser(0, 5, 5)
//        checkUserScore(0, 5)
//    }
//
//    @Test
//    fun newScore_single_lowerScore() = applicationTest {
//        givenUsersAdded()
//        runBlocking {
//            repo.setScore(0, 5)
//        }
//        newScoreValidUser(0, 2, 5)
//        checkUserScore(0, 5)
//    }
//
//    @Test
//    fun newScore_multiple() = applicationTest {
//        givenUsersAdded()
//        runBlocking {
//            repo.setScore(0, 5)
//            repo.setScore(1, 6)
//            repo.setScore(2, 7)
//        }
//        newScoreValidUser(0, 3, 5)
//        newScoreValidUser(1, 10, 10)
//        newScoreValidUser(2, 7, 7)
//        checkUserScores(
//            Pair(0, 5),
//            Pair(1, 10),
//            Pair(2, 7)
//        )
//    }
//
//    @Test
//    fun newScore_noParam() = applicationTest {
//        givenUsersAdded()
//        newScoreNoParam(0)
//        checkUserScore(0, 0)
//    }
//
//    @Test
//    fun newScore_invalidScore() = applicationTest {
//        givenUsersAdded()
//        newScoreInvalidScore(0, "Seven")
//        checkUserScore(0, 0)
//    }
//
//    @Test
//    fun newScore_nonexistentUser() = applicationTest {
//        givenUsersAdded()
//        checkNoUsers(3)
//        newScoreNonexistentUser(3, 5)
//        checkNoUsers(3)
//    }
//
//    @Test
//    fun newScore_invalidId() = applicationTest {
//        givenUsersAdded()
//        newScoreInvalidUserId(USER_NAME_0, 5)
//        checkUserScore(0, 0)
//    }
//
//    @Test
//    fun topScores_noUsers() = applicationTest {
//        getTopScorers(10.toString(), emptyList())
//    }
//
//    @Test
//    fun topScores_noParam() = applicationTest {
//        givenTopScoresTestUsersAdded()
//        getTopScorers(expectedScoreList = TOP_SCORES_TEST_USER_SCORES_SORTED.take(10))
//    }
//
//    @Test
//    fun topScores_takeFifteen() = applicationTest {
//        givenTopScoresTestUsersAdded()
//        getTopScorers(15.toString(), TOP_SCORES_TEST_USER_SCORES_SORTED.take(15))
//    }
//
//    @Test
//    fun topScores_takeOneHundred() = applicationTest {
//        givenTopScoresTestUsersAdded()
//        getTopScorers(100.toString(), TOP_SCORES_TEST_USER_SCORES_SORTED)
//    }
//
//    @Test
//    fun topScores_invalidParam() = applicationTest {
//        givenTopScoresTestUsersAdded()
//        getTopScorers("Twenty", TOP_SCORES_TEST_USER_SCORES_SORTED.take(10))
//    }
//
//    private fun applicationTest(testBlock: suspend ApplicationTestBuilder.() -> Unit) =
//        testApplication {
//            application {
//                testing = true
//            }
//            testBlock()
//        }
//
//    private fun TestApplicationCall.assertStatus(code: HttpStatusCode) {
//        assertEquals(code, response.status())
//    }
//
//    private fun TestApplicationEngine.getUser(userId: String, testBlock: TestApplicationCall.() -> Unit) {
//        handleRequest(HttpMethod.Get, uri="/user/$userId").apply(testBlock)
//    }
//
//    private fun TestApplicationEngine.getValidUser(expectedUser: User) {
//        getUser(expectedUser.id.toString()) {
//            assertStatus(OK)
//            assertEquals(expectedUser, decodeFromString<User>(response.content ?: "{}"))
//        }
//    }
//
//    private fun TestApplicationEngine.getNonexistentUser(userId: Long) {
//        getUser(userId.toString()) {
//            userNotFound(userId.toString())
//        }
//    }
//
//    private fun TestApplicationEngine.getUserInvalidId(userId: String) {
//        getUser(userId) {
//            invalidUserId()
//        }
//    }
//
//    private fun TestApplicationEngine.newUser(name: String) {
//        handleRequest(Post, uri="/newUser?name=$name").apply {
//            assertStatus(OK)
//            try {
//                val newUser = decodeFromString<User>(response.content ?: "{}")
//                assertEquals(name, newUser.name)
//                assertEquals(0, newUser.highScore)
//            } catch (e: Exception) {
//                fail(e.message)
//            }
//        }
//    }
//
//    private fun TestApplicationEngine.newUserNoName() {
//        handleRequest(Post, uri="/newUser").apply {
//            assertFalse(response.isSent)
//        }
//    }
//
//    private fun TestApplicationEngine.updateUser(
//        userId: String,
//        name: String? = null,
//        score: String? = null,
//        testBlock: TestApplicationCall.() -> Unit
//    ) {
//        val uri = "/user/$userId/update" + if (name != null && score != null) {
//            "?name=$name&score=$score"
//        } else if (name != null) {
//            "?name=$name"
//        } else if (score != null) {
//            "?score=$score"
//        } else {
//            ""
//        }
//        handleRequest(Post, uri).apply(testBlock)
//    }
//
//    private fun TestApplicationEngine.updateValidUser(userId: Long, name: String? = null, score: Long? = null) {
//        if (name == null && score == null) {
//            throw(IllegalArgumentException("For valid update user test, at least one of name and score must be present."))
//        }
//        updateUser(userId.toString(), name, score?.toString()) {
//            assertStatus(OK)
//            try {
//                val responseUser = decodeFromString<User>(response.content ?: "{}")
//                assertEquals(userId, responseUser.id)
//                name?.let {
//                    assertEquals(it, responseUser.name)
//                }
//                score?.let {
//                    assertEquals(it, responseUser.highScore)
//                }
//            } catch (e: Exception) {
//                fail(e.message)
//            }
//        }
//    }
//
//    private fun TestApplicationEngine.updateNonExistentUser(userId: Long, name: String? = null, score: Long? = null) {
//        updateUser(userId.toString(), name, score?.toString()) {
//            userNotFound(userId.toString())
//        }
//    }
//
//    private fun TestApplicationEngine.updateUserNoParams(userId: Long) {
//        updateUser(userId.toString()) {
//            invalidUpdateQueryParameters()
//        }
//    }
//
//    private fun TestApplicationEngine.updateUserInvalidScore(userId: Long, name: String? = null, score: String) {
//        updateUser(userId.toString(), name, score) {
//            invalidUpdateQueryParameters()
//        }
//    }
//
//    private fun TestApplicationEngine.updateUserInvalidUserId(userId: String, name: String? = null, score: Long? = null) {
//        updateUser(userId, name, score?.toString()) {
//            assertStatus(OK)
//            assertEquals("userId must be a valid long", response.content)
//        }
//    }
//
//    private fun TestApplicationEngine.newScore(
//        userId: String,
//        score: String? = null,
//        testBlock: TestApplicationCall.() -> Unit
//    ) {
//        val uri = "/user/$userId/newScore" + if (score != null) { "?score=$score" } else { "" }
//        handleRequest(Post, uri).apply(testBlock)
//    }
//
//    private fun TestApplicationEngine.newScoreValidUser(userId: Long, newScore: Long, expectedScore: Long) {
//        newScore(userId.toString(), newScore.toString()) {
//            assertStatus(OK)
//            try {
//                val returnedUser = decodeFromString<User>(response.content ?: "")
//                assertEquals(userId, returnedUser.id)
//                assertEquals(expectedScore, returnedUser.highScore)
//            } catch (e: Exception) {
//                fail(e.message)
//            }
//        }
//    }
//
//    private fun TestApplicationEngine.newScoreInvalidScore(userId: Long, newScore: String) {
//        newScore(userId.toString(), newScore) {
//            assertStatus(OK)
//            assertEquals(
//                "Must include query parameter score with valid long value",
//                response.content
//            )
//        }
//    }
//
//    private fun TestApplicationEngine.newScoreNoParam(userId: Long) {
//        newScore(userId.toString()) {
//            assertFalse(response.isSent)
//        }
//    }
//
//    private fun TestApplicationEngine.newScoreNonexistentUser(userId: Long, newScore: Long) {
//        newScore(userId.toString(), newScore.toString()) {
//            userNotFound(userId.toString())
//        }
//    }
//
//    private fun TestApplicationEngine.newScoreInvalidUserId(userId: String, newScore: Long) {
//        newScore(userId, newScore.toString()) {
//            invalidUserId()
//        }
//    }
//
//    private fun TestApplicationEngine.getTopScorers(count: String? = null, expectedScoreList: List<Long>) {
//        val uri = "/topScores" + if (count != null) { "?count=$count" } else { "" }
//        handleRequest(HttpMethod.Get, uri).apply {
//            assertStatus(OK)
//            assertEquals(
//                expectedScoreList,
//                decodeFromString<List<User>>(response.content ?: "{}")
//                    .map { it.highScore }
//                    .sortedDescending()
//            )
//        }
//    }
//
//    private fun TestApplicationCall.userNotFound(userId: String) {
//        assertStatus(OK)
//        assertEquals("No user found with ID $userId", response.content)
//    }
//
//    private fun TestApplicationCall.invalidUserId() {
//        assertStatus(OK)
//        assertEquals("userId must be a valid long", response.content)
//    }
//
//    private fun TestApplicationCall.invalidUpdateQueryParameters() {
//        assertStatus(OK)
//        assertEquals(
//            "At least one of query parameters name and score must be provided. score must be a valid long",
//            response.content
//        )
//    }
//
//    private fun givenUsersAdded() {
//        givenUsersAdded(USER_NAME_0, USER_NAME_1, USER_NAME_2)
//    }
//
//    private fun givenUsersAdded(vararg names: String) {
//        runBlocking {
//            names.forEach {
//                repo.addUser(it)
//            }
//        }
//    }
//
//    private fun givenTopScoresTestUsersAdded() {
//        givenUsersAdded(*TOP_SCORES_TEST_USER_NAMES.toTypedArray())
//        runBlocking {
//            TOP_SCORES_TEST_USER_SCORES.forEachIndexed { index, score ->
//                repo.setScore(index.toLong(), score)
//            }
//        }
//    }
//
//    private fun checkUser(user: User) {
//        assertEquals(user, repo.getUser(user.id))
//    }
//
//    private fun checkUsers(vararg users: User) {
//        users.forEach {
//            checkUser(it)
//        }
//    }
//
//    private fun checkUserName(userId: Long, name: String) {
//        assertEquals(name, repo.getName(userId))
//    }
//
//    private fun checkUserNames(vararg users: Pair<Long, String>) {
//        users.forEach {
//            checkUserName(it.first, it.second)
//        }
//    }
//
//    private fun checkUserScore(userId: Long, score: Long) {
//        assertEquals(score, repo.getScore(userId))
//    }
//
//    private fun checkUserScores(vararg users: Pair<Long, Long>) {
//        users.forEach {
//            checkUserScore(it.first, it.second)
//        }
//    }
//
//    private fun checkNoUsers(vararg userIds: Long) {
//        userIds.forEach {
//            assertFalse(repo.hasUser(it))
//        }
//    }

}