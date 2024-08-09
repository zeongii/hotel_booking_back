
INSERT INTO city (city_name)
VALUES ('Seoul'),
       ('Busan'),
       ('Incheon'),
       ('Daegu'),
       ('Gwangju'),
       ('Daejeon'),
       ('Ulsan'),
       ('Jeju'),
       ('Suwon'),
       ('Gyeongju');

-- Insert multiple rows into the hotel_coupon table with dummy data

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
INSERT INTO facility (infinity_pool, indoor_pool, sauna, kids_room, casino, fitness_center, free_wifi, laundry_room,
                      front_desk, restaurant, free_parking, bar, atm, outdoor_garden)
VALUES (1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1),
       (1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0),
       (0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1),
       (1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0),
       (1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1),
       (0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0),
       (1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1),
       (0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1),
       (1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0),
       (1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1);

INSERT INTO hotel (hotel_name, hotel_address, hotel_phone, hotel_email, hotel_grade, hotel_facilities)
VALUES ('호텔 서울', '서울특별시 중구', '02-1234-5678', 'seoulhotel@example.com', 5, '수영장, 스파'),
       ('부산 호텔', '부산광역시 해운대구', '051-8765-4321', 'busanhotel@example.com', 4, '휘트니스 센터, 사우나'),
       ('인천 호텔', '인천광역시 중구', '032-3456-7890', 'incheonhotel@example.com', 3, '비즈니스 센터, 무료 와이파이'),
       ('대구 호텔', '대구광역시 수성구', '053-9876-5432', 'daeguhotel@example.com', 5, '룸 서비스, 공항 셔틀'),
       ('광주 호텔', '광주광역시 서구', '062-4321-9876', 'gwangjuhotel@example.com', 4, '카페, 레스토랑'),
       ('대전 호텔', '대전광역시 유성구', '042-6543-2109', 'daejeonhotel@example.com', 4, '바, 피트니스 클럽'),
       ('울산 호텔', '울산광역시 남구', '052-6789-1234', 'ulsanhotel@example.com', 3, '회의실, 컨퍼런스룸'),
       ('세종 호텔', '세종특별자치시', '044-1234-5678', 'sejonghotel@example.com', 5, '공용 주방, 공동 라운지'),
       ('수원 호텔', '경기도 수원시 팔달구', '031-8765-4321', 'suwonhotel@example.com', 4, '야외 수영장, 실내 수영장'),
       ('제주 호텔', '제주특별자치도 제주시', '064-9876-5432', 'jejuhotel@example.com', 5, '해변, 무료 조식');


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
     ('jisu.miller@example.com', 'password123', 'jisu', 'jisu', 'USER', '707 Cherry Circle', 'Female', '1', 10, 10000, 1);


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

-- RoomEntity 더미 데이터
INSERT INTO room (room_name, room_max, room_price, room_content, check_in, check_out, breakfast_price)
VALUES ('Deluxe Room', 2, 200000, 'Spacious room with a king-sized bed.', '2024-08-01 14:00:00', '2024-08-02 12:00:00',
        15000),
       ('Suite', 4, 500000, 'Luxury suite with a separate living area.', '2024-08-01 14:00:00', '2024-08-02 12:00:00',
        30000),
       ('Standard Room', 2, 150000, 'Comfortable room with all standard amenities.', '2024-08-01 14:00:00',
        '2024-08-02 12:00:00', 10000),
       ('Family Room', 5, 300000, 'Room perfect for families, includes extra beds.', '2024-08-01 14:00:00',
        '2024-08-02 12:00:00', 20000),
       ('Single Room', 1, 100000, 'Cozy room for single travelers.', '2024-08-01 14:00:00', '2024-08-02 12:00:00',
        5000),
       ('Double Room', 2, 180000, 'Room with a double bed and a beautiful view.', '2024-08-01 14:00:00',
        '2024-08-02 12:00:00', 15000),
       ('Twin Room', 2, 170000, 'Room with two separate beds.', '2024-08-01 14:00:00', '2024-08-02 12:00:00', 15000),
       ('Presidential Suite', 6, 1000000, 'Top-tier luxury suite.', '2024-08-01 14:00:00', '2024-08-02 12:00:00',
        50000),
       ('Economy Room', 2, 80000, 'Basic room for budget travelers.', '2024-08-01 14:00:00', '2024-08-02 12:00:00',
        5000),
       ('Studio Room', 2, 220000, 'Studio-style room with kitchen facilities.', '2024-08-01 14:00:00',
        '2024-08-02 12:00:00', 20000);

-- RoomTypeEntity 더미 데이터
INSERT INTO room_type (type_name, type_content)
VALUES ('Single', 'Single bed for one person.'),
       ('Double', 'Double bed for two people.'),
       ('Twin', 'Two single beds for two people.'),
       ('Suite', 'Luxury suite with separate living area.'),
       ('Deluxe', 'Spacious room with premium amenities.'),
       ('Family', 'Room for families with extra beds.'),
       ('Presidential', 'Top-tier luxury suite with exclusive features.'),
       ('Economy', 'Basic room for budget travelers.'),
       ('Studio', 'Studio-style room with kitchen facilities.'),
       ('Standard', 'Standard amenities for comfortable stay.');


-- TripEntity 더미 데이터
INSERT INTO hotel_trip (trip_name, trip_content)
VALUES ('Seoul Tour', 'Explore the historic sites and modern attractions of Seoul.'),
       ('Busan Beach', 'Relax at the beautiful beaches of Busan.'),
       ('Jeju Island', 'Discover the natural beauty of Jeju Island.'),
       ('Gyeongju Heritage', 'Experience the ancient history of Gyeongju.'),
       ('DMZ Visit', 'Learn about the Korean War at the DMZ.'),
       ('Andong Culture', 'Experience traditional Korean culture in Andong.'),
       ('Gangwon Mountains', 'Hike the scenic mountains of Gangwon-do.'),
       ('Incheon Airport', 'Enjoy the amenities of Incheon International Airport.'),
       ('Jeonju Hanok Village', 'Explore traditional Korean houses in Jeonju.'),
       ('Ulleungdo Adventure', 'Discover the unique island of Ulleungdo.');



