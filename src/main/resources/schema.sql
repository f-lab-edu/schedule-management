DROP TABLE IF EXISTS `todo`;
DROP TABLE IF EXISTS `project`;

CREATE TABLE IF NOT EXISTS project(
    `id` bigint auto_increment not null,
    `name` varchar(255),
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    primary key(`id`)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS todo(
    `id` bigint auto_increment not null,
    `todo` varchar(255),
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    `project_id` bigint,
    primary key(`id`),
    foreign key(`project_id`) references `project`(`id`) on delete cascade
) engine=InnoDB;