<template>
  <div>
    <h2 class="title">People</h2>

    <table class="table is-stripped is-fullwidth">
      <thead>
      <tr>
        <th>Name</th>
        <th>Palindrome</th>
        <th>Authorised</th>
        <th>Enabled</th>
        <th>Colours</th>
      </tr>
      </thead>
      <tbody>
      <!--
      TODO: Step 6
      Add styles to Palindrome, Authorised and Enabled values.
      When the value is Yes the text colour should be Green.
      When the value is No the text colour should be Red.
      -->

      <tr v-for="person in people" :key="person.id">
        <td>
          <router-link
            :to="{name: 'person-edit', params: { id: person.id }}"
          >{{person | fullName}}
          </router-link>
        </td>
        <td>{{person | palindrome}}</td>
        <td>{{person.authorised ? 'Yes' : 'No'}}</td>
        <td>{{person.enabled ? 'Yes' : 'No'}}</td>
        <td>{{person.colours | colourNames}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import {getPeople} from '../api/people-api';

export default Vue.extend({
  async created() {
    this.people = await getPeople();
  },
  data() {
    const people: IPerson[] = [];

    return {
      people,
    };
  },
  computed: {

  },
  filters: {
    colourNames: (colours: IColour[]): string => {
      // TODO: Step 4
      //
      // Implement the value converter function.
      // Using the colours parameter, convert the list into a comma
      // separated string of colour names. The names should be sorted
      // alphabetically and there should not be a trailing comma.
      //
      // Example: "Blue, Green, Red"

      let sortedColours = colours;

      // Sort
      sortedColours = sortedColours.sort((a: IColour, b: IColour) => {
        if (a.name < b.name) {
          return -1;
        }
        if (a.name > b.name) {
          return 1;
        }
        return 0;
      });

      // Array to csv string
      let colourString: string = '';
      for (const colour of sortedColours) {
        colourString += colour.name + ', ';
      }

      // Remove last comma and space
      colourString = colourString.replace(/, $/, '');
      return colourString;
    },
    fullName: (person: IPerson): string => {
      return `${person.firstName} ${person.lastName}`;
    },
    palindrome: (person: IPerson): string => {
      const fullName = `${person.firstName} ${person.lastName}`;
      // TODO: Step 5
      //
      // Implement the palindrome computed field.
      // True should be returned When the FullName is spelt the same
      // forwards as it is backwards. The match should ignore any
      // spaces and should also be case insensitive.
      //
      // Example: "Bo Bob" is a palindrome.

      // Make non case sensitive and remove spaces
      let palindromeString: string = fullName.toUpperCase();
      palindromeString = palindromeString.replace(/ /g, '');

      const length = palindromeString.length;
      for (let i = 0; i < length / 2; i++) {
        if (palindromeString[i] !== palindromeString[length - 1 - i]) {
          return 'No';
        }
      }
      return 'Yes';
    },
  },
});
</script>

<style lang="sass">

</style>

