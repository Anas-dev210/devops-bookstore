# Stage 1: Build (optional for static AngularJS)
FROM node:18 AS builder
WORKDIR /app
COPY . .
# No build step needed for AngularJS — it's already static

# Stage 2: Serve with Nginx
FROM nginx:alpine
COPY ./app /usr/share/nginx/html/app
COPY ./index.html /usr/share/nginx/html/index.html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]