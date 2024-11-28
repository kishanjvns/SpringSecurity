INSERT INTO App_User (username, password, is_expired, created_at, updated_at)
VALUES ('john_doe', 'password123', FALSE, NOW(), NOW());

INSERT INTO App_User (username, password, is_expired, created_at, updated_at)
VALUES ('king', 'password123', FALSE, NOW(), NOW());


INSERT INTO authorities (username, authority, created_at, updated_at)
VALUES ('john_doe', 'Write', NOW(), NOW());

INSERT INTO authorities (username, authority, created_at, updated_at)
VALUES ('king', 'READ', NOW(), NOW());
