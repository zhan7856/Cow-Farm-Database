-- Execute the following "story" using your functions:


    -- We built our first farm in Pine Island Minnesota (55963) on Country 27 Blvd, starting on January 1st, 2024

    CALL addFarm('Country 27 Blvd', 'Pine Island', 'MN', '55963')

    -- We started with 5 cows: Buttercup, Clarabelle, Daisy, Bella, and Bessie - their ear tags were our first ones (1,2,3,4, and 5)

    CALL addCow(1, 'Buttercup', 1);
    CALL addCow(2, 'Clarabelle', 1);
    CALL addCow(3, 'Daisy', 1);
    CALL addCow(4, 'Bella', 1);
    CALL addCow(5, 'Bessie', 1);

    -- We had acquired our only sole milking machine and milk tank from a friend who was upgrading their equipment

    CALL purchaseMachine(1);
    CALL purchaseTank(1, '2024-01-01', null);

    -- We had to make weekly trips to a neighboring farm to get alfalfa every Wednesday, getting 175 lbs (2800 oz). Every other week, we would get an additional 17.5 lbs (280 oz) of corn for a little extra nutritional variation for the cows

    CALL purchaseFeed(1, '2024-01-03', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-01-03', 280, 'corn');
    CALL purchaseFeed(1, '2024-01-10', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-01-17', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-01-17', 280, 'corn');
    CALL purchaseFeed(1, '2024-01-24', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-01-31', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-01-31', 280, 'corn');
    CALL purchaseFeed(1, '2024-02-07', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-02-14', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-02-14', 280, 'corn');
    CALL purchaseFeed(1, '2024-02-21', 2800, 'alfalfa');  
    CALL purchaseFeed(1, '2024-02-28', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-02-28', 280, 'corn');
    CALL purchaseFeed(1, '2024-03-06', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-03-13', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-03-13', 280, 'corn');
    CALL purchaseFeed(1, '2024-03-20', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-03-27', 2800, 'alfalfa');
    CALL purchaseFeed(1, '2024-03-27', 280, 'corn');

    -- My business partner and I were the only workers on the farm (Fred & George Cowherd), so we had a lot to manage

    CALL hireHand('Fred', 'Cowherd', 1);
    CALL hireHand('George', 'Cowherd', 1);  

    -- Our first week of milking was stressful, but enjoyable as we got ourselves and our cows into a routine. We kept our first day of milking records framed in our office:
            -- Date	   Time	     Cow	    Collection
            -- 1/1	7:02-7:05	Bella	       300
            -- 1/1	7:07-7:13	Clarabelle	   234
            -- 1/1	7:16-7:23	Bessie	       274
            -- 1/1	7:28-7:36	Daisy	       186
            -- 1/1	7:53-8:08	Buttercup	   235
            -- 1/1	11:23-11:33	Daisy	       247
            -- 1/1	11:48-12:05	Bella          211
            -- 1/1	12:12-12:30	Buttercup	   198
            -- 1/1	12:33-12:45	Clarabelle	   275
            -- 1/1	12:49-13:05	Bessie	       286
            -- 1/1	15:02-15:15	Bessie	       187
            -- 1/1	15:23-15:45	Clarabelle	   232
            -- 1/1	15:58-16:11	Buttercup	   311
            -- 1/1	16:21-16:30	Daisy	       312
            -- 1/1	16:33-16:46	Bella	       257


    CALL milkingEvent(1, 4, '2024-01-01', '07:02:00', '07:05:00', 300);
    CALL milkingEvent(1, 2, '2024-01-01', '07:07:00', '07:13:00', 234);
    CALL milkingEvent(1, 5, '2024-01-01', '07:16:00', '07:23:00', 274);
    CALL milkingEvent(1, 3, '2024-01-01', '07:28:00', '07:36:00', 186);
    CALL milkingEvent(1, 1, '2024-01-01', '07:53:00', '07:53:00', 235);

    CALL milkingEvent(1, 3, '2024-01-01', '11:23:00', '11:33:00', 247);
    CALL milkingEvent(1, 4, '2024-01-01', '11:48:00', '12:05:00', 211);
    CALL milkingEvent(1, 1, '2024-01-01', '12:12:00', '12:30:00', 198);
    CALL milkingEvent(1, 2, '2024-01-01', '12:33:00', '12:45:00', 275);
    CALL milkingEvent(1, 5, '2024-01-01', '12:49:00', '13:05:00', 286);

    CALL milkingEvent(1, 5, '2024-01-01', '15:02:00', '15:15:00', 187);
    CALL milkingEvent(1, 2, '2024-01-01', '15:23:00', '15:45:00', 232);
    CALL milkingEvent(1, 1, '2024-01-01', '15:58:00', '16:11:00', 311);
    CALL milkingEvent(1, 3, '2024-01-01', '16:21:00', '16:30:00', 312);
    CALL milkingEvent(1, 4, '2024-01-01', '16:33:00', '16:46:00', 257);

    -- Because we wanted to make sure the delivery process would work, we scheduled our first milk delivery for January 1st at 15:46 from the Local Co-Op. The Co-Op picked it up and processed the milk for sale on the market

    CALL milkDelivery(1, 1, 'ABCD1234', 1, '2024-01-01');