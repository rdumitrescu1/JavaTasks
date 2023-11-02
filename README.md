1. Install Postman REST Client

2. Create Account in Trello using PERSONAL mail (not Grid)

3. Sign In to Account

4. Get and save API Key: https://trello.com/app-key

5. Get token (Use token button)

6. Check that everything works by typing the URL to the address line: https://api.trello.com/1/members/me?key={YOUR_KEY}&token={YOUR_TOKEN}

7. If step 6 returned JSON go to step 8 if not go to Google

8. Create a Postman collection for:

- Creating a new board (POST)

- Getting board by ID (GET)

- Updating board (PUT)

- Removing board (DELETE)
