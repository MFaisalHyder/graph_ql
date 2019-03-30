INSERT INTO Author(ID, firstName, middleName, lastName, residentialAddress, officeAddress, mobileNumber, telephoneNumber, identityType, identityNumber, gender) VALUES (-1, 'Jeff', '', 'Bezos', 'Amazon bay area', 'Santa clara', '+0017853245', '+0224343542344', 'Security', '4353453US_AM', 'male')
INSERT INTO Author(ID, firstName, middleName, lastName, residentialAddress, officeAddress, mobileNumber, telephoneNumber, identityType, identityNumber, gender) VALUES (-2, 'Bruce', 'K.', 'Eckel', 'New York bay area', 'Nashville hill area', '+0454755853245', '+0224656542344', 'NIC', '423113345US_AM', 'male')
INSERT INTO Author(ID, firstName, middleName, lastName, residentialAddress, officeAddress, mobileNumber, telephoneNumber, identityType, identityNumber, gender) VALUES (-3, 'Pervaiz', 'Khan', 'Musharraf', 'James Hotel', 'JBR Dubai', '+00199797245', '+0224343542344', 'EmiratesID', '4655336457653', 'male')
INSERT INTO Author(ID, firstName, middleName, lastName, residentialAddress, officeAddress, mobileNumber, telephoneNumber, identityType, identityNumber, gender) VALUES (-4, 'Cynthia', 'J.', 'Monika', 'Burj As Salam', 'Business Bay', '+00766563245', '+9714377655344', 'EmiratesID', '3645768867876', 'female')
INSERT INTO Author(ID, firstName, middleName, lastName, residentialAddress, officeAddress, mobileNumber, telephoneNumber, identityType, identityNumber, gender) VALUES (-5, 'Jeff', 'Macron', 'Lancer', 'Tendon Hotel Apartment', 'Satwa Falcon', '+078766993245', '+9714377565344', 'EmiratesID', '3643656467876', 'male')

INSERT INTO Publisher(ID, name, licenseNumber, address, contactNumber) VALUES (-6, 'Peterson Publishing media groups', 'UAE_DXB_PPMG-971', 'Dubai World Trade Centre', '+97152333343232')
INSERT INTO Publisher(ID, name, licenseNumber, address, contactNumber) VALUES (-7, 'B&B JK. Publishing media groups', 'UAE_DXB_BBJK_971', 'Jumeira Beach Residence', '+97152878674797')
INSERT INTO Publisher(ID, name, licenseNumber, address, contactNumber) VALUES (-8, 'Dexon Printing and Publishing Group', 'UAE_DXB_DPPG-971', 'Al Barsha South', '+9715654753475')
INSERT INTO Publisher(ID, name, licenseNumber, address, contactNumber) VALUES (-9, 'Cantaloupe Media House', 'UAE_DXB_CMH-971', 'International City, Daytona House', '+971523876954')

INSERT INTO Book(ID, title, ISBN, pageCount, author_ID) VALUES (-10, 'How I found Amazon', 'JeffBez_001', 200, -1)
INSERT INTO Book(ID, title, ISBN, pageCount, author_ID) VALUES (-11, 'Introduction to Java', 'BruceK._001', 540, -2)
INSERT INTO Book(ID, title, ISBN, pageCount, author_ID) VALUES (-12, 'Pride of Nation', 'Pervaiz_001', 700, -3)
INSERT INTO Book(ID, title, ISBN, pageCount, author_ID) VALUES (-13, 'How to brave enemies', 'Pervaiz_002', 650, -3)
INSERT INTO Book(ID, title, ISBN, pageCount, author_ID) VALUES (-14, 'Stages of Life', 'Cynthia_001', 100, -4)

INSERT INTO Book_Publishers VALUES(-10, -6)
INSERT INTO Book_Publishers VALUES(-10, -8)
INSERT INTO Book_Publishers VALUES(-10, -9)
INSERT INTO Book_Publishers VALUES(-11, -7)
INSERT INTO Book_Publishers VALUES(-11, -8)
INSERT INTO Book_Publishers VALUES(-12, -6)
INSERT INTO Book_Publishers VALUES(-12, -8)
INSERT INTO Book_Publishers VALUES(-12, -9)
INSERT INTO Book_Publishers VALUES(-13, -6)
INSERT INTO Book_Publishers VALUES(-14, -9)


