package com.example.gitsocial.domain

class User : Follower {
    private var avatar_url: String? = null
    private var login: String? = null
    private var mPlan: Plan? = null
    private var id: String? = null

    constructor() {}

    constructor(builder: Builder) {
        avatar_url = builder.avatar_url
        login = builder.login
        mPlan = builder.mPlan
        id = builder.id
    }

    fun toBuilder(): Builder {
        return Builder().plan(mPlan)
                .avatar_url(avatar_url)
                .login(login)
                .id(id)
    }

    fun plan(): Plan? {
        return mPlan
    }

    override fun avatar_url(): String? {
        return avatar_url
    }

    override fun login(): String? {
        return login
    }

    override fun id(): String? {
        return id
    }

    class Builder : Follower.Builder() {
        var mPlan: Plan? = null
        var avatar_url: String? = null
        var login: String? = null
        var id: String? = null

        override fun id(id: String?): Builder {
            this.id = id
            return this
        }

        fun plan(plan: Plan?): Builder {
            mPlan = plan
            return this
        }

        override fun avatar_url(avatar: String?): Builder {
            avatar_url = avatar
            return this
        }

        override fun login(username: String?): Builder {
            login = username
            return this
        }

        fun build(): User {
            return User(this)
        }
    }

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
                    .deleted(false) as Builder
        }
    }
}