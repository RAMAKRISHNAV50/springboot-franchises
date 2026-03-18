-- ─────────────────────────────────────────────────────────────────────────────
-- franchise/src/main/resources/data.sql
--
-- CRITICAL: franchise_name values MUST exactly match the TEAM_COLORS keys
-- in your frontend (AdminDashboard.jsx, BidRoom.jsx, AuctionDashboard.jsx):
--
--   'Mumbai Indians'
--   'Chennai Super Kings'
--   'Royal Challengers Bengaluru'
--   'Kolkata Knight Riders'
--   'Delhi Capitals'
--   'Rajasthan Royals'
--   'Punjab Kings'
--   'Sunrisers Hyderabad'
--
-- Fixes from original file:
--   1. franchise_name now has the FULL team name (was short code: MI, CSK…)
--   2. name column now has the short team code (used as display alias)
--   3. Added Punjab Kings and Sunrisers Hyderabad (were missing — but exist in TEAM_COLORS)
--   4. Gujarat Titans removed — not in your frontend TEAM_COLORS map
-- ─────────────────────────────────────────────────────────────────────────────

INSERT INTO franchise (name, franchise_name, owner_name, state, networth, email, password) VALUES
                                                                                               ('MI',  'Mumbai Indians',              'Nita Ambani',      'Maharashtra', 1000000000.0, 'mi@ipl.com',  'pass123'),
                                                                                               ('CSK', 'Chennai Super Kings',         'N. Srinivasan',    'Tamil Nadu',  1000000000.0, 'csk@ipl.com', 'pass123'),
                                                                                               ('RCB', 'Royal Challengers Bengaluru', 'United Spirits',   'Karnataka',   1000000000.0, 'rcb@ipl.com', 'pass123'),
                                                                                               ('KKR', 'Kolkata Knight Riders',       'Shah Rukh Khan',   'West Bengal', 1000000000.0, 'kkr@ipl.com', 'pass123'),
                                                                                               ('DC',  'Delhi Capitals',              'Parth Jindal',     'Delhi',       1000000000.0, 'dc@ipl.com',  'pass123'),
                                                                                               ('RR',  'Rajasthan Royals',            'Manoj Badale',     'Rajasthan',   1000000000.0, 'rr@ipl.com',  'pass123'),
                                                                                               ('PBKS','Punjab Kings',                'Preity Zinta',     'Punjab',      1000000000.0, 'pbks@ipl.com','pass123'),
                                                                                               ('SRH', 'Sunrisers Hyderabad',         'Kavya Maran',      'Telangana',   1000000000.0, 'srh@ipl.com', 'pass123');