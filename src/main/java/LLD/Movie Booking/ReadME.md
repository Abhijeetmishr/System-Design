## Requirements
City Selection Functionality  : The application must present a list of cities from which the user can select.
Movie Listing for Selected City 
Upon city selection, the application must display a list of movies currently showing in the selected city.
The movie list should include essential information such as movie title
Theater Listing for Selected Movie:
When a user selects a movie, the application must show a list of theaters where the movie is being screened.
The list should include the theater name, location, and available showtimes
Show Listing for Selected Theater: 
When a user selects a specific theater, the application must display a list of all shows available at that theater for given movie
     
     5. Seat Booking for a Selected Movie at a Given Screen
Once a user selects a movie and showtime at a specific theater, the application must display a seating chart of the corresponding screen.
Each seat should be clearly marked as available, booked, or unavailable (for maintenance or other


## API's

1. List<Movie> searchAll();
2. List<Movie> searchbyFilter(Filter filter)
3. List<Theatre> getAllTheatre(Location location)
4. List<Show> getAllShow(Long theatreId, Long movieId);
5. Booking bookTicket(Long showId);

## Classes

User
- id: Long
- name: String

City
-id
-name
-theatres: List<Theatre>

Theatre
 - id: Long
 - name: String
 - location: Location
 - shows: List<Show>


Show
- id: Long
- startTime
- endTime
- Movie
- seats: List<Seat>


Booking
- id
- showId
- ticket:Ticket

Ticket
 -id
 -price
 -seat: List<Seat>
- timetsamp


Seat
 - ID
 - status
 - seatType


Movie
-id
-name
-description
-title
-language
-genre
-length
