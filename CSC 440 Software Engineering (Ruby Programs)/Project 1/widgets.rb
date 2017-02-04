#!/usr/bin/ruby -w
# This program reads in a CSV file of widgets and re-formats it to a new file

require 'csv'

widgets = CSV.read('widgets.csv') # file to read

out = File.new('widgets.out', 'w+') # file to write to

widgets.each do |row| # the last two columns need to be swapped for proper formatting
  row[row.size-1], row[row.size-2] = row[row.size-2], row[row.size-1]
end

widgets[0].each do |head| # print the headers
  out.printf('%-5s ', head)
end
out.print("\n") # extra line for readability

# initialize variables to keep track of attribute values and totals
state, plant, dept, empid = widgets[1][0], widgets[1][1], widgets[1][2], widgets[1][3]
state_total, plant_total, dept_total, grand_total = 0, 0, 0, 0

# loop to print each row of values, displaying totals where necessary
widgets.slice(1...widgets.size).each_with_index do |row, index|
  out.print("\n") # extra line for readability

  # loop through current row to print values
  row.each_with_index do |val, i|
    if i == 5 # "Name" is formatted differently
      out.printf('%-20s', val)
    else
      out.printf('%5s ', val)
    end
  end

  # update current values and totals
  state, plant, dept, empid = row[0], row[1], row[2], row[3]
  state_total += row[4].to_i
  plant_total += row[4].to_i
  dept_total += row[4].to_i
  grand_total += row[4].to_i

  # need to check the next index for a change in state, plant, or department
  # must increment by 2 for data type
  n = index + 2

  if n < widgets.size
    if state != widgets[n][0] # state change triggers print & reset all 3 totals
      out.printf("\n\n%30d %-15s %2s *", dept_total, 'TOTAL FOR DEPT', dept)
      out.printf("\n%30d %-15s %2s **", plant_total, 'TOTAL FOR PLANT', plant)
      out.printf("\n%30d %-15s %2s ***\n", state_total, 'TOTAL FOR STATE', state)
      dept_total = 0
      plant_total = 0
      state_total = 0
    elsif plant != widgets[n][1] # plant change triggers print & reset dept & plant totals
      out.printf("\n\n%30d %-15s %2s *", dept_total, 'TOTAL FOR DEPT', dept)
      out.printf("\n%30d %-15s %2s **\n", plant_total, 'TOTAL FOR PLANT', plant)
      plant_total = 0
      dept_total = 0
    elsif dept != widgets[n][2] # dept change triggers print & reset dept totals
      out.printf("\n\n%30d %-15s %2s *\n", dept_total, 'TOTAL FOR DEPT', dept)
      dept_total = 0
    end
  end
end

# print a final summary
out.printf("\n\n%30d %-15s %2s *", dept_total, 'TOTAL FOR DEPT', dept)
out.printf("\n%30d %-15s %2s **", plant_total, 'TOTAL FOR PLANT', plant)
out.printf("\n%30d %-15s %2s ***\n", state_total, 'TOTAL FOR STATE', state)
out.printf("\n%30d %-15s    ****\n", grand_total, 'GRAND TOTAL')


