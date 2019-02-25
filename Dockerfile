# Use root/example as user/password credentials
  mongo:
    image: mongo-springboo
    restart: always
    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD:

  mongo-express:
    image: mongo-springboo
    restart: always
    ports:
      - 27017:27017
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: admin
      ME_CONFIG_MONGODB_ADMINPASSWORD: