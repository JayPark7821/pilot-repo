# SET
#     REFERENTIAL_INTEGRITY FALSE;
#
# TRUNCATE TABLE USERS;
# ALTER TABLE USERS
#     ALTER COLUMN ID RESTART WITH 1;
#
# TRUNCATE TABLE POST;
# ALTER TABLE POST
#     ALTER COLUMN ID RESTART WITH 1;
#
#
# insert into users (id, created_at, created_by,updated_at, updated_by, name) values
# (999, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser1'),
# (998, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser2'),
# (997, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser3'),
# (996, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser4'),
# (995, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser5'),
# (994, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'testUser6')
# ;
#
#
#
# insert into builderPost (id, created_at, created_by,updated_at, updated_by, content, title, user_id) values
# (999, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content1', 'title1', 999),
# (998, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content2', 'title2', 998),
# (997, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content3', 'title3', 997),
# (996, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content4', 'title4', 996),
# (995, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content5', 'title5', 995),
# (994, '2023-09-02 01:55:15.188498', 'SYSTEM', '2023-09-26 00:20:50.521017', 'SYSTEM', 'content6', 'title6',994 )
# ;
#
