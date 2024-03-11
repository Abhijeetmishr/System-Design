-- Requirement: Design database schema for a social media platform with tables for users, posts, comments, likes, and followers.
-- Q. What will be some of the features?
    -- Users should be able to view and edit their profile
        -- Users
            --id
            --firstName
            --lastName
            --email
            --phone_no
        CREATE TABLE USER (
            id INT PRIMARY KEY,
            firstName VARCHAR(50),
            lastName VARCHAR(50),
            email VARCHAR(50),
            phone_no VARCHAR(50)
        );

    -- Users should be able to create posts
        --Posts
            --id
            --user_id(fk)
            --content
            --created_at
            --modified_at
        CREATE TABLE POST (
            id INT PRIMARY KEY,
            user_id INT, 
            content VARCHAR(50),
            created_at DATE,
            modified_at DATE,
            FOREIGN KEY (user_id) REFERENCES User(id)
        )
    -- Users should be able to comment on posts
        --Comments
            --id
            --user_id(fk)
            --post_id(fk)
            --content
            --created_at
            --modified_at

    -- Users should be able to like a post
        --PostLike
            --id
            --user_id(fk)
            --post_id(fk)
            
    -- Users should be able to like a comment
        --CommentLike
            --id
            --user_id(fk)
            --comment_id(fk)
        
    -- Users should be able to follow another user
        --Followers
            --id
            --follower_id(fk)
            --following_id(fk)
            
        CREATE TABLE Followers (
            id INT PRIMARY KEY,
            follower_id INT,
            following_id INT,
            FOREIGN KEY (follower_id) REFERENCES Users(id),
            FOREIGN KEY (following_id) REFERENCES Users(id)
        );
