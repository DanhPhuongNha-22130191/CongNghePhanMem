-- Insert brands
INSERT INTO brands (name, is_deleted)
VALUES (N'Hunter Laing', 0),
       (N'Kill Devil', 0),
       (N'Cadenheads', 0),
       (N'Merlot', 0),
       (N'Glengoyne', 0);

-- Hunter Laing (brand_id = 1) - Whisky products
INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted)
VALUES
    (1, N'Hunter Laing Classic Malt', 250, N'Smooth single malt whisky with notes of vanilla and honey.',
     'Hunter_Laing_1.png', 700, 46.0, N'In stock', 2018, 0),
    (1, N'Hunter Laing Limited Edition', 280, N'Rich smoky flavor with a long, warming finish.',
     'Hunter_Laing_2.png', 700, 46.0, N'In stock', 2019, 0),
    (1, N'Hunter Laing Peated Reserve', 300, N'Bold peated whisky with hints of oak and spice.',
     'Hunter_Laing_3.png', 700, 50.0, N'In stock', 2020, 0),
    (1, N'Hunter Laing Sherry Cask', 320, N'Whisky matured in sherry casks, rich in dried fruits and nuts.',
     'Hunter_Laing_4.png', 700, 46.0, N'In stock', 2017, 0),
    (1, N'Hunter Laing Vintage 12 Years', 350, N'Classic 12-year-old whisky with a balanced and smooth profile.',
     'Hunter_Laing_5.png', 700, 40.0, N'In stock', 2016, 0);

-- Kill Devil (brand_id = 2) - Rum products
INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted)
VALUES
    (2, N'Kill Devil Spiced Rum', 260, N'Spiced rum with rich caramel and vanilla aromas.',
     'Kill_Devil_1.jpg', 750, 40.0, N'In stock', 2020, 0),
    (2, N'Kill Devil Dark Rum', 280, N'Deep and robust rum with notes of molasses and oak.',
     'Kill_Devil_2.png', 750, 40.0, N'In stock', 2019, 0),
    (2, N'Kill Devil White Rum', 250, N'Clean and crisp white rum, perfect for cocktails.',
     'Kill_Devil_3.png', 750, 40.0, N'In stock', 2021, 0),
    (2, N'Kill Devil Barrel Aged', 300, N'Rum aged in oak barrels for a smooth, complex taste.',
     'Kill_Devil_4.png', 750, 46.0, N'In stock', 2018, 0),
    (2, N'Kill Devil Reserve', 320, N'Premium reserve rum with rich spices and vanilla finish.',
     'Kill_Devil_5.png', 750, 46.0, N'In stock', 2017, 0);

-- Cadenheads (brand_id = 3) - Whisky products
INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted)
VALUES
    (3, N'Cadenheads Small Batch', 310, N'Handcrafted whisky with bold peat and malt character.',
     'Cadenheads_1.png', 700, 50.0, N'In stock', 2017, 0),
    (3, N'Cadenheads Vintage Release', 340, N'Rare vintage whisky with layered complexity.',
     'Cadenheads_2.png', 700, 50.0, N'In stock', 2015, 0),
    (3, N'Cadenheads Sherry Cask', 330, N'Whisky matured in sherry casks for a rich, fruity profile.',
     'Cadenheads_3.png', 700, 46.0, N'In stock', 2016, 0),
    (3, N'Cadenheads Peat Monster', 350, N'Intense peated whisky with smoky and earthy tones.',
     'Cadenheads_4.png', 700, 50.0, N'In stock', 2018, 0),
    (3, N'Cadenheads Collector Edition', 370, N'Exclusive release with smooth, complex flavors.',
     'Cadenheads_5.png', 700, 50.0, N'In stock', 2014, 0);

-- Merlot (brand_id = 4) - Red Wine products
INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted)
VALUES
    (4, N'Merlot Signature', 300, N'Full-bodied wine with velvety tannins and rich fruit.',
     'Merlot_3.jpg', 750, 14.0, N'In stock', 2019, 0),
    (4, N'Merlot Barrel Aged', 310, N'Merlot aged in oak barrels for a complex aroma.',
     'Merlot_4.jpg', 750, 14.0, N'In stock', 2018, 0),
    (4, N'Merlot Private Collection', 320, N'Premium selection with intense flavors and smooth finish.',
     'Merlot_5.jpg', 750, 14.0, N'In stock', 2021, 0);

-- Glengoyne (brand_id = 5) - Whisky products
INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted)
VALUES
    (5, N'Glengoyne 18 Year Old', 350, N'Elegant whisky matured in sherry casks with complex flavors.',
     'Glengoyne_2.png', 700, 46.0, N'In stock', 2016, 0),
    (5, N'Glengoyne Classic', 260, N'Soft and approachable whisky, ideal for newcomers.',
     'Glengoyne_5.png', 700, 40.0, N'In stock', 2020, 0);
