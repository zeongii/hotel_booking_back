INSERT INTO city (city_name)
VALUES ('Seoul'),
       ('Gyeonggi'),
       ('Incheon'),
       ('Daegu'),
       ('Gwangju'),
       ('Daejeon'),
       ('Ulsan'),
       ('Jeju'),
       ('Suwon'),
       ('Gyeongju'),
       ('Busan');

-- Insert multiple rows into the hotel_coupon table with dummy data

INSERT INTO facility (facility_name)
VALUES ('야외수영장'),
       ('실내수영장'),
       ('사우나'),
       ('키즈룸'),
       ('카지노'),
       ('피트니스센터'),
       ('무료와이파이'),
       ('세탁시설'),
       ('스파'),
       ('24시간 프론트 데스크'),
       ('레스토랑'),
       ('무료주차'),
       ('바'),
       ('ATM'),
       ('야외정원');

INSERT INTO hotel_coupon (cou_name, cou_type, cou_value, enabled, created_time, updated_time)
VALUES ('Summer Sale 2024', 'Percentage', 15, true, '2024-08-06 10:00:00', '2024-08-06 10:00:00'),
       ('Winter Discount', 'Fixed', 5000, true, '2024-08-06 10:01:00', '2024-08-06 10:01:00'),
       ('Spring Special', 'Percentage', 10, true, '2024-08-06 10:02:00', '2024-08-06 10:02:00'),
       ('Holiday Offer', 'Percentage', 20, true, '2024-08-06 10:03:00', '2024-08-06 10:03:00'),
       ('New Year Deal', 'Fixed', 10000, true, '2024-08-06 10:04:00', '2024-08-06 10:04:00'),
       ('Black Friday', 'Percentage', 25, true, '2024-08-06 10:05:00', '2024-08-06 10:05:00'),
       ('Cyber Monday', 'Fixed', 2000, true, '2024-08-06 10:06:00', '2024-08-06 10:06:00'),
       ('Early Bird', 'Percentage', 5, true, '2024-08-06 10:07:00', '2024-08-06 10:07:00'),
       ('Mid-Year Sale', 'Fixed', 3000, true, '2024-08-06 10:08:00', '2024-08-06 10:08:00'),
       ('Loyalty Reward', 'Percentage', 10, false, '2024-08-06 10:09:00', '2024-08-06 10:09:00');

INSERT INTO hotel (hotel_name, hotel_address, hotel_phone, hotel_email, hotel_grade, city_id)
VALUES ('호텔 서울', '서울특별시 중구', '02-1234-5678', 'seoulhotel@example.com', 5, 1),
       ('부산 호텔', '부산광역시 해운대구', '051-8765-4321', 'busanhotel@example.com', 4, 2),
       ('인천 호텔', '인천광역시 중구', '032-3456-7890', 'incheonhotel@example.com', 3, 3),
       ('대구 호텔', '대구광역시 수성구', '053-9876-5432', 'daeguhotel@example.com', 5, 4),
       ('광주 호텔', '광주광역시 서구', '062-4321-9876', 'gwangjuhotel@example.com', 4, 5),
       ('대전 호텔', '대전광역시 유성구', '042-6543-2109', 'daejeonhotel@example.com', 4, 6),
       ('울산 호텔', '울산광역시 남구', '052-6789-1234', 'ulsanhotel@example.com', 3, 7),
       ('세종 호텔', '세종특별자치시', '044-1234-5678', 'sejonghotel@example.com', 5, 8),
       ('수원 호텔', '경기도 수원시 팔달구', '031-8765-4321', 'suwonhotel@example.com', 4, 9),
       ('제주 호텔', '제주특별자치도 제주시', '064-9876-5432', 'jejuhotel@example.com', 5, 10);

INSERT INTO hotel_facility (hotel_id, facility_id)
VALUES (1, 1), (1, 3), (1, 5), (1, 7), (1, 9), (1, 11), (1, 13),
       (2, 2), (2, 4), (2, 6), (2, 7), (2, 10), (2, 13),
       (3, 3), (3, 6), (3, 9), (3, 12), (3, 15),
       (4, 4), (4, 8), (4, 12),
       (5, 5), (5, 10), (5, 15),
       (6, 3), (6, 5), (6, 7);

INSERT INTO user (email, password, name, nickname, role, address, user_gender, phone, user_grade, user_total_amount,
                  enabled)
VALUES ('john.doe@example.com', 'password123', 'John Doe', 'johnny', 'USER', '123 Maple Street', 'Male', '123-456-7890',
        1, 1000, 1),
       ('jane.smith@example.com', 'password123', 'Jane Smith', 'janey', 'USER', '456 Oak Avenue', 'Female',
        '234-567-8901', 2, 2000, 1),
       ('mike.jones@example.com', 'password123', 'Mike Jones', 'mikey', 'USER', '789 Pine Road', 'Male', '345-678-9012',
        3, 3000, 1),
       ('lisa.brown@example.com', 'password123', 'Lisa Brown', 'lisaB', 'USER', '101 Cedar Lane', 'Female',
        '456-789-0123', 4, 4000, 1),
       ('tom.wilson@example.com', 'password123', 'Tom Wilson', 'tommy', 'USER', '202 Birch Boulevard', 'Male',
        '567-890-1234', 5, 5000, 1),
       ('nancy.white@example.com', 'password123', 'Nancy White', 'nanc', 'USER', '303 Spruce Drive', 'Female',
        '678-901-2345', 6, 6000, 1),
       ('steve.green@example.com', 'password123', 'Steve Green', 'steveG', 'USER', '404 Elm Court', 'Male',
        '789-012-3456', 7, 7000, 1),
       ('mary.hall@example.com', 'password123', 'Mary Hall', 'maryH', 'USER', '505 Willow Place', 'Female',
        '890-123-4567', 8, 8000, 1),
       ('dave.adams@example.com', 'password123', 'Dave Adams', 'daveA', 'USER', '606 Aspen Way', 'Male', '901-234-5678',
        9, 9000, 1),
       ('susan.miller@example.com', 'password123', 'Susan Miller', 'susie', 'USER', '707 Cherry Circle', 'Female',
        '012-345-6789', 10, 10000, 1),
       ('jisu.miller@example.com', 'password123', 'jisu', 'jisu', 'USER', '707 Cherry Circle', 'Female', '1', 10, 10000,
        1);


INSERT INTO hotel_pay (pay_price, pay_date, pay_way)
VALUES (100000, '2024-08-01 12:30:00', 'Credit Card'),
       (200000, '2024-08-02 14:00:00', 'Debit Card'),
       (150000, '2024-08-03 16:45:00', 'Bank Transfer'),
       (300000, '2024-08-04 10:15:00', 'PayPal'),
       (250000, '2024-08-05 09:30:00', 'Credit Card'),
       (175000, '2024-08-06 11:20:00', 'Cash'),
       (225000, '2024-08-07 13:50:00', 'Credit Card'),
       (275000, '2024-08-08 15:35:00', 'Debit Card'),
       (325000, '2024-08-09 17:10:00', 'Bank Transfer'),
       (350000, '2024-08-10 18:55:00', 'Credit Card');

INSERT INTO room_reservation (start_date, end_date, reservation_number, pay_price, is_breakfast, enabled)
VALUES ('2024-08-01', '2024-08-05', 'RES123456', 500000, 1, 1),
       ('2024-08-06', '2024-08-10', 'RES123457', 600000, 0, 1),
       ('2024-08-11', '2024-08-15', 'RES123458', 550000, 1, 1),
       ('2024-08-16', '2024-08-20', 'RES123459', 700000, 1, 0),
       ('2024-08-21', '2024-08-25', 'RES123460', 800000, 0, 1),
       ('2024-08-26', '2024-08-30', 'RES123461', 900000, 1, 1),
       ('2024-09-01', '2024-09-05', 'RES123462', 450000, 0, 1),
       ('2024-09-06', '2024-09-10', 'RES123463', 650000, 1, 0),
       ('2024-09-11', '2024-09-15', 'RES123464', 750000, 1, 1),
       ('2024-09-16', '2024-09-20', 'RES123465', 850000, 0, 1);


-- ReviewEntity 더미 데이터
INSERT INTO hotel_review (room_type, reservation_id, clean_rating, traffic_rating, facility_rating, total_rating,
                          review_title, review_content)
VALUES (1, 101, 5, 4, 5, 4.7, 'Great Room!', 'Very clean and well maintained.'),
       (2, 102, 4, 3, 4, 3.7, 'Good Service', 'Staff were friendly and helpful.'),
       (3, 103, 3, 2, 3, 2.7, 'Average Stay', 'Room was okay, but could be cleaner.'),
       (1, 104, 5, 5, 5, 5.0, 'Perfect Experience', 'Everything was perfect!'),
       (2, 105, 4, 4, 4, 4.0, 'Nice Hotel', 'Good location and comfortable rooms.'),
       (3, 106, 3, 3, 3, 3.0, 'Decent Stay', 'It was decent, nothing special.'),
       (1, 107, 5, 4, 4, 4.3, 'Very Good', 'Great value for the price.'),
       (2, 108, 4, 4, 3, 3.7, 'Good Enough', 'Decent service and rooms.'),
       (3, 109, 3, 3, 2, 2.7, 'Not Great', 'Could be better maintained.'),
       (1, 110, 5, 5, 5, 5.0, 'Excellent', 'Loved every bit of my stay!');

-- RoomTypeEntity 더미 데이터
INSERT INTO room_type (id, type_name, type_content) VALUES
                                                        (1, '스탠다드+싱글+시티뷰', 'A'),
                                                        (2, '스탠다드+싱글+오션뷰', 'B'),
                                                        (3, '스탠다드+더블+시티뷰', 'C'),
                                                        (4, '스탠다드+더블+오션뷰', 'D'),
                                                        (5, '디럭스+싱글+시티뷰', 'E'),
                                                        (6, '디럭스+싱글+오션뷰', 'F'),
                                                        (7, '디럭스+더블+시티뷰', 'G'),
                                                        (8, '디럭스+더블+오션뷰', 'H'),
                                                        (9, '스위트+시티뷰', 'I'),
                                                        (10, '스위트+오션뷰', 'J'),
                                                        (11, '레지던스+시티뷰', 'K'),
                                                        (12, '레지던스+오션뷰', 'L');
-- RoomEntity 더미 데이터
INSERT INTO room (room_name, room_max, room_price, room_content, breakfast_price, hotel_id, room_type_id)
VALUES ('Deluxe Room', 2, 200000, 'Spacious room with a king-sized bed.', 15000, 1, 3),
       ('Suite', 4, 500000, 'Luxury suite with a separate living area.', 30000, 2, 4),
       ('Standard Room', 2, 150000, 'Comfortable room with all standard amenities.', 10000, 1, 1),
       ('Family Room', 5, 300000, 'Room perfect for families, includes extra beds.', 20000, 3, 2),
       ('Single Room', 1, 100000, 'Cozy room for single travelers.', 5000, 1, 5),
       ('Double Room', 2, 180000, 'Room with a double bed and a beautiful view.', 15000, 4, 7),
       ('Twin Room', 2, 170000, 'Room with two separate beds.', 15000, 2, 4),
       ('Presidential Suite', 6, 1000000, 'Top-tier luxury suite.', 50000, 5, 7),
       ('Economy Room', 2, 80000, 'Basic room for budget travelers.', 5000, 1, 6),
       ('Studio Room', 2, 220000, 'Studio-style room with kitchen facilities.', 20000, 9, 8);




-- TripEntity 더미 데이터
INSERT INTO hotel_trip (trip_name, trip_content)
VALUES
    ('Seoul Tour', 'Explore the historic sites and modern attractions of Seoul.'),
    ('Busan Beach', 'Relax at the beautiful beaches of Busan.'),
    ('Jeju Island', 'Discover the natural beauty of Jeju Island.'),
    ('Gyeongju Heritage', 'Experience the ancient history of Gyeongju.'),
    ('DMZ Visit', 'Learn about the Korean War at the DMZ.'),
    ('Andong Culture', 'Experience traditional Korean culture in Andong.'),
    ('Gangwon Mountains', 'Hike the scenic mountains of Gangwon-do.'),
    ('Incheon Airport', 'Enjoy the amenities of Incheon International Airport.'),
    ('Jeonju Hanok Village', 'Explore traditional Korean houses in Jeonju.'),
    ('Ulleungdo Adventure', 'Discover the unique island of Ulleungdo.');
