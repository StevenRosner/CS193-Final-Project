# CS193-Final-Project

## Overview
A Java-based command-line program that fetches real-time weather data via an API and applies decision logic to recommend appropriate clothing outfits.

## Tech Stack
* **Language:** Java
* **API:** OpenWeatherMap API
* **Data Storage:** Local JSON / CSV rules file

## System Architecture / Build Flow
1. **CLI Input Prompt:** User enters their location.
2. **Weather API Client:** Fetches current weather conditions via HTTP.
3. **Data Parser:** Extracts temperature, wind, and precipitation data.
4. **Outfit Database Loader:** Loads local clothing rules.
5. **Decision Engine Logic:** Filters items based on thresholds.
6. **Console Output:** Displays the recommended outfit.
