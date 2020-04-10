CREATE TABLE video_room (
    id BINARY(16) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT video_room_pk  KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  video_room_participants (
    video_room_id BINARY(16) NOT NULL,
	user_id INT(20) NOT NULL,
	created DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;