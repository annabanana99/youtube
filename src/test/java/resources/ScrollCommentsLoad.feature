@VideoPlaying
Feature: Comments loading

  Background: Comments below a Youtube video should load dynamically as the page is being scrolled.

  Scenario: Playing/Pausing a video
    Given The page is loaded
    When the page is scrolled
    Then some comments appear
    When the page is scrolled some more
    Then more comments appear