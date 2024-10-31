# ecommerce_clothing



# To access a user API secured with JWT in a Spring Boot application, you need to ensure that you include the Bearer token in your HTTP Authorization header correctly. Here's how to do that step-by-step:

# 1. Extract the Token From your JSON response, extract the accessToken:

# "accessToken": "eyJhbGciOi..."
# 2. Set Up HTTP Request
# When making requests to your user API, include the token in the Authorization header. Here’s an example using different methods:

# Using Postman:
# Open Postman and select the HTTP method (GET, POST, etc.) for your request.
# Enter the API endpoint URL.
# Go to the Authorization tab.
# Select Bearer Token from the Type dropdown.
# Paste the accessToken into the token field.
# Send the request.
