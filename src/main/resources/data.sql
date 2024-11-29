INSERT INTO App_User (username, password, enabled, created_at, updated_at)
VALUES ('john_doe', 'password123', 1, NOW(), NOW());

INSERT INTO App_User (username, password, enabled, created_at, updated_at)
VALUES ('king', 'password123', 1, NOW(), NOW());


INSERT INTO authorities (username, authority, created_at, updated_at)
VALUES ('john_doe', 'Write', NOW(), NOW());

INSERT INTO authorities (username, authority, created_at, updated_at)
VALUES ('king', 'READ', NOW(), NOW());
